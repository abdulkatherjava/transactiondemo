package org.example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ExecutionFlow {

    @Pointcut ("within(org..service.*) || within(org..repository.*)")
    public void logMethodPointCut() {

    }

    @Around("logMethodPointCut()")
    public Object logAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String methodName = proceedingJoinPoint.getSignature().getName();
        System.out.println("Inside the " + methodName +" method");
        Object object = proceedingJoinPoint.proceed();
        return object;
    }

//    @Before("logMethodPointCut()")
//    public void logBeforeMethodCall() {
//        System.out.println("Before Method Call");
//    }
//    @After("logMethodPointCut()")
//    public void logAfterMethodCall() {
//        System.out.println("After Method Call");
//    }
}
