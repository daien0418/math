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
@Order(1)
public class Aop1 {

    @Pointcut("execution(* com.dai.en.aop.AopService.*(..))")
    private void pointCut() {}

    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {
        System.out.println("aop---1");
//        System.out.println(joinPoint.getTarget());
    }

    @After("pointCut()")
    public void After(JoinPoint joinPoint){
        System.out.println("after---1");
    }

    @AfterReturning("pointCut()")
    public void AfterReturning(JoinPoint joinPoint){
        System.out.println("afterReturn---1");
    }

    @AfterThrowing("pointCut()")
    public void AfterThrowing(JoinPoint joinPoint){
        System.out.println("afterThrow---1");
    }

    @Around("pointCut()")
    public Object  arround(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("arround---1");
        Object rtValue = null;
        try {
            rtValue = pjp.proceed();
        } catch (Throwable e) {
            throw e;
        }
        System.out.println("arround---1");
        return rtValue;
    }
}
