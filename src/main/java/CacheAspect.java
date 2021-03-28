import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.Objects;

@Aspect
@Configuration
public class CacheAspect {
    @Resource
    RedisTemplate<String, Object> redisTemplate;

    @Around("@annotation(com.github.hcsp.annotations.Cache)")
    public Object cache(ProceedingJoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getName();
        Object cacheValue = redisTemplate.opsForValue().get(methodName);

        if (cacheValue != null) {
            System.out.println("Get value from cache");
            return cacheValue;
        } else {
            System.out.println("Get value from database");
            return getCacheFromDatabase(joinPoint, methodName);
        }
    }

    private Object getCacheFromDatabase(ProceedingJoinPoint joinPoint, String methodName) {
        Object realValue = null;
        try {
            realValue = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        redisTemplate.opsForValue().set(methodName, Objects.requireNonNull(realValue));
        return realValue;
    }
}
