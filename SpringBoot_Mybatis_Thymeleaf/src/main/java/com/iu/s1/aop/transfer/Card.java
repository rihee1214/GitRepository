package com.iu.s1.aop.transfer;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Card {

	//@Before("execution(* com.iu.s1.aop.transfer.Transfer.*())")
	//@After("execution(* com.iu.s1.aop.transfer.Transfer.*())")
	//@AfterThrowing("execution(* com.iu.s1.aop.transfer.Transfer.*())")
	@Around("execution(* com.iu.s1.aop.transfer.Transfer.*())")
	public Object cardCheck(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("----- 탑승 전 카드 체크 -----");
		//joinPoint - 핵심 메서드(버스, 지하철)를 객체화시킨다.
		Object obj =  joinPoint.proceed();
		System.out.println("----- 하차 시 카드 체크 -----");
		return obj;
	}
	
	//접근 지정자는 생략가능하다
	@AfterReturning("execution(public * com.iu.s1.board.notice.NoticeService.get*(..))")
	public void selectCheck() {
		System.out.println("Select Query 정상종료");
	}
}
