package liga.medical.personservice.core.aspect;

import liga.medical.model.dto.enums.ServiceType;
import liga.medical.personservice.core.utils.api.LogHelper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Component
@Aspect
public class LoggingAspect {

    @Autowired
    private LogHelper logHelper;

    @Pointcut("@annotation(liga.medical.personservice.core.annotation.DbLog)")
    public void dbLogPointcut() {

    }

    @Before("dbLogPointcut()")
    public void beforeAllRepositoryMethodAdvice(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] methodArgs = joinPoint.getArgs();

        log.info("UUID {} | Сервис {} | Вызван метод {} : {}() с аргументами {}",
                logHelper.getId(), ServiceType.SERVICE, className, methodName, Arrays.deepToString(methodArgs));
    }

    @AfterReturning("dbLogPointcut()")
    public void afterReturningAllRepositoryMethodAdvice(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] methodArgs = joinPoint.getArgs();

        log.info("UUID {} | Сервис {} | Отработан метод {} : {}() с аргументами {}",
                logHelper.getId(), ServiceType.SERVICE, className, methodName, Arrays.deepToString(methodArgs));
    }

    @AfterThrowing(pointcut = "dbLogPointcut()", throwing = "exception")
    public void afterThrowingAllRepositoryMethodAdvice(JoinPoint joinPoint,
                                                       Throwable exception) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] methodArgs = joinPoint.getArgs();

        log.info("UUID {} | Сервис {} | Метод завершен с исключением {} : {}() с аргументами {} : Исключение {}",
                logHelper.getId(), ServiceType.SERVICE, className, methodName, Arrays.deepToString(methodArgs), exception.getMessage());
    }
}
