package com.sample.aop;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ExceptionAdvice {
	
	@AfterThrowing(pointcut = "execution(* com.sample.service.*.*(..))")
	 public void handleException() {
		 System.out.println("예외가 발생하였습니다.");
	 }
}
