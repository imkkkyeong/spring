package com.sample.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
public class RunningTimeCheckAdvice {
	
	/**
	 *@Around("bean(*Service)")
	 *joinPoint의 ProcddeingJoinPoint 
	 * 공통 관심사가 적용되는 조인포인트를 표현하는 객체이다
	 * 조인포인트(대상메서드실행)가 포함된 대상 객체, 대상 메서드, 대상 메서드 실행시 전달되는 인자값 등을 획득 할 수 있다. 
	 * ProceedingJoinPoint는 around advice 전용이다. 
	 * ProceedingJoinPoint는 대상 메서드를 실행하는 기능이 포함되어 있다. 
	 * around advice가 대상메서드에 전처리/후처리를 수행하기 위해서는 around advice 내부에서 대상 메서드를 실행해야한다.
	 * proceed()메서드를 실행하면 대상 메서드가 실행된다.
	 * proceed() 메서드를 실행하면 대상메서드가 실행되고 반환하는 반환값이 returnValue에 대입된다
	 */
	@Around("bean(*Service)")
	public Object checkRunningTime(ProceedingJoinPoint joinPoint) throws Throwable {
		
		System.out.println("실행시작 시간을 체크한다");
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		Object returnValue = joinPoint.proceed(); // 대상메서드를 실행하고 반환값을 받는다.
												 // 대상메서드의 반환타입이 void면 null을 반환받는다.
		
		// 대상 메서드 실행 후 코드

		System.out.println("실행종료 시간을 체크하고, 총 실행시간을 계산한다");
		stopWatch.stop();
		long totleTimeMillis = stopWatch.getTotalTimeMillis();
		System.out.println("실행시간 :" + totleTimeMillis + "밀리초");
		
		return returnValue;
	}
}
