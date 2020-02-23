package com.github.hcsp;

import com.github.hcsp.annotation.Cache;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Aspect
@Configuration
public class CacheAspect {
    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    Map<CacheKey, CacheValue> cache = new HashMap<>();
    //拦截带有某种注解的方法
//    @Around("@annotation(com.github.hcsp.annotation.Cache)")
    public Object cache(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        //方法名
        //参数
        //对象
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();

        Method method = signature.getMethod();
        Object[] args = proceedingJoinPoint.getArgs();
        Object thisObject = proceedingJoinPoint.getThis();
        CacheKey cacheKey = new CacheKey(method.getName(), args, thisObject);
        CacheValue cacheValue = cache.get(cacheKey);
        if ( cacheValue!=null && !cacheExpire(cacheValue, method) ){
            System.out.println("hit cache");
            return cache.get(cacheKey).value;
        } else {
            System.out.println("gen cache");
            cacheValue = new CacheValue(proceedingJoinPoint.proceed(), System.currentTimeMillis());
            cache.put(cacheKey, cacheValue);
            return cacheValue.value;
        }
    }

    @Around("@annotation(com.github.hcsp.annotation.Cache)")
    public Object cacheByRedis(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = methodSignature.getMethod();
        String methodName = method.getName();

        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        CacheValue cache = (CacheValue) redisTemplate.opsForValue().get( methodName );
        if (cache==null || cacheExpire(cache, method)){
            cache = new CacheValue(proceedingJoinPoint.proceed(), System.currentTimeMillis());
            redisTemplate.opsForValue().set( methodName, cache );
        }
        return cache.value;
    }


    private static class CacheValue implements Serializable {
        private static final long serialVersionUID = 4125096758372084309L;
        private Object value;
        private long time;
        CacheValue(Object value, long time){
            this.time = time;
            this.value = value;
        }
    }

    private static boolean cacheExpire(CacheValue cacheValue, Method method){
        return System.currentTimeMillis() - cacheValue.time > method.getAnnotation(Cache.class).cacheSeconds() * 1000;
    }

    private static class CacheKey{
        private String methodName;
        private Object[] arguments;
        private Object thisObject;

        CacheKey(String methodName, Object[] arguments, Object thisObject){
            this.methodName = methodName;
            this.arguments = arguments;
            this.thisObject = thisObject;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o){
                return true;
            }
            if (o == null || getClass() != o.getClass()){
                return false;
            }
            CacheKey cacheKey = (CacheKey) o;
            return Objects.equals(methodName, cacheKey.methodName) &&
                    Arrays.equals(arguments, cacheKey.arguments) &&
                    Objects.equals(thisObject, cacheKey.thisObject);
        }

        @Override
        public int hashCode() {
            int result = Objects.hash(methodName, thisObject);
            result = 31 * result + Arrays.hashCode(arguments);
            return result;
        }
    }
}
