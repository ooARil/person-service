package liga.medical.personservice.core.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class MyPointcuts {

    @Pointcut("execution(* liga.medical.personservice.core.controller.*.*(..))")
    public void allRestMethods() {

    }

    @Pointcut("execution(* liga.medical.personservice.core.security.controller.*.*(..))")
    public void allSecurityRestMethods() {

    }
}
