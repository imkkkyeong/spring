package com.sample.aop;

import java.util.StringJoiner;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


/**
 * @Component
 * 	이 클래스를 스프링 컨테이너가 자동으로 스캔해서 객체 생성하는 대상으로 지정한다.
 * 
 * @Aspect
 * `이 클래스가 공통관심사항이 구현된 클래스임을 나타낸다.
 *
 */
@Component
@Aspect
public class LoggingAdvice {
	
	@Before("within(com.sample.service.*)")
	public void logging(JoinPoint joinpoint) {
		// 공통기능이 적용되는 대상객체를 반환한다.
		Object target = joinpoint.getTarget();
		//공통기능이 적용되는 대상 메서드 정보가 포함된 객체를 반환한다.
		Signature signature = joinpoint.getSignature();
		//공통기능이 적용되는 대상 메서드의 매개변수로 전달되는 인자값을 반환한다.
		Object[] args = joinpoint.getArgs();
		 
		String className = target.getClass().getName();
		String methodName = signature.getName();
		
		StringJoiner joiner = new StringJoiner(",");
		 for(Object obj : args) {
	            String value = obj.toString();
	            joiner.add(value);
	         }
	         
	         System.out.println("["+className+"] " + methodName + "("+joiner.toString()+") 실행됨");
	         
	         System.out.println("logging , 로그출력");
	      }

	}
	

