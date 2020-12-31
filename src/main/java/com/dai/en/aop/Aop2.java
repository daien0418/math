package com.dai.en.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class Aop2 {

    @Pointcut("execution(* com.dai.en.aop.AopService.*(..))")
    private void pointCut() {}

    @Before("pointCut()")
    public void arroundLogger(JoinPoint joinPoint) {
        System.out.println("aop 2");
//        System.out.println(joinPoint.getTarget());
    }

    @After("pointCut()")
    public void After(JoinPoint joinPoint){
        System.out.println("after---2");
    }

    @AfterReturning("pointCut()")
    public void AfterReturning(JoinPoint joinPoint){
        System.out.println("afterReturn---2");
    }

    @AfterThrowing("pointCut()")
    public void AfterThrowing(JoinPoint joinPoint){
        System.out.println("afterThrow---2");
    }

    @Around("pointCut()")
    public Object arround(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("arround---2");
        Object rtValue = null;
        try {
            Object[] args = new Object[1];
            args[0]="234";
            rtValue=pjp.proceed(args);
            rtValue = "modified";
//            args[0]="2345";
//            rtValue = pjp.proceed(args);
//            args[0]="23456";
//            rtValue = pjp.proceed(args);
        } catch (Throwable e) {
            throw e;
        }
        System.out.println("arround---2");
        return rtValue;
    }
}
