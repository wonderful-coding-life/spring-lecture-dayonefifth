package com.example.demo;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class PrintHttpHeaderAspect {
    @Before("@annotation(PrintHttpHeader)")
    public void printExecutionTime(JoinPoint joinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        System.out.println("header accept = " + request.getHeader("Accept"));
        System.out.println("current attribute = " + RequestContextHolder.currentRequestAttributes());
        System.out.println("do before " + joinPoint.toShortString());
    }
}
