package liga.medical.personservice.core.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Component
@Aspect
public class SecurityLoggingAspect {

    @Before("MyPointcuts.allSecurityRestMethods()")
    public void beforeAllSecurityRepositoryMethodAdvice(JoinPoint joinPoint) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName();
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] methodArgs = joinPoint.getArgs();

        log.info("Пользователь: {} | Вызван метод {} : {}() с аргументами {}",
                userName, className, methodName, Arrays.deepToString(methodArgs));
    }

    @AfterReturning("MyPointcuts.allSecurityRestMethods()")
    public void afterReturningAllSecurityRepositoryMethodAdvice(JoinPoint joinPoint) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName();
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] methodArgs = joinPoint.getArgs();

        log.info("Пользователь: {} | Отработан метод {} : {}() с аргументами {}",
                userName, className, methodName, Arrays.deepToString(methodArgs));
    }

    @AfterThrowing(pointcut = "MyPointcuts.allSecurityRestMethods()", throwing = "exception")
    public void afterThrowingAllRepositoryMethodAdvice(JoinPoint joinPoint,
                                                       Throwable exception) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName();
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] methodArgs = joinPoint.getArgs();

        log.info("Пользователь: {} | Метод завершен с исключением {} : {}() с аргументами {} : Исключение {}",
                userName, className, methodName, Arrays.deepToString(methodArgs), exception.getMessage());
    }
}