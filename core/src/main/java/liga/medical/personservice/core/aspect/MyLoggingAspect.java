package liga.medical.personservice.core.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyLoggingAspect {

    @Before("execution(* liga.medical.personservice.core.controller.*.*(..))")
    public void beforeAllRepositoryMethodAdvice(JoinPoint joinPoint)  {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String methodName = methodSignature.getName();

        System.out.println("Начало работы метода: " + methodName);
    }

    @AfterReturning("execution(* liga.medical.personservice.core.controller.*.*(..))")
    public void afterReturningAllRepositoryMethodAdvice(JoinPoint joinPoint)  {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String methodName = methodSignature.getName();

        System.out.println("Метод был успешно отработан: " + methodName);
    }
}
