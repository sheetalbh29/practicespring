package com.infogain.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class ProductAspect {
	@Before("execution(public boolean isValidquantityInHand())")
	public void log1() {
		System.out.println("BEFORE!!");
	}
//@AfterReturning(pointcut="execution(public boolean isValidquantityInHand())",returning="result")
//public void log1(JoinPoint jp,Object result) {
//	
//}
}
