package com.github.hcsp;

import com.github.hcsp.annotation.Cache;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Aspect
@Configuration//标记这是一个配置类
public class CacheAspect {
    Map<CacheKey, CacheValue> cache = new HashMap<>();
    //拦截带有某种注解的方法
    @Around("@annotation(com.github.hcsp.annotation.Cache)")
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
        if( cacheValue!=null && !cacheExpire(cacheValue, method) ){
            System.out.println("hit cache");
            return cache.get(cacheKey).value;
        }else{
            System.out.println("gen cache");
            cacheValue = new CacheValue(proceedingJoinPoint.proceed(), System.currentTimeMillis());
            cache.put(cacheKey, cacheValue);
            return cacheValue.value;
        }
    }

    private static class CacheValue{
        private Object value;
        private long time;
        public CacheValue(Object value, long time){
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

        public CacheKey(String methodName, Object[] arguments, Object thisObject){
            this.methodName = methodName;
            this.arguments = arguments;
            this.thisObject = thisObject;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
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
