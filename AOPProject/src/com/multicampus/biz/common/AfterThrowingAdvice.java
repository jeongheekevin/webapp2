package com.multicampus.biz.common;

import java.sql.SQLException;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterThrowingAdvice {

	@AfterThrowing(pointcut="PointcutCommon.allPointcut()", throwing="exceptObj")
	public void exceptionLog(JoinPoint jp, Exception exceptObj) {
		String method = jp.getSignature().getName();
		
		System.out.println("[���� ó��] " + method + 
			"() �޼ҵ� ���� �� ���� �߻�");
		
		if(exceptObj instanceof ArithmeticException) {
			System.out.println("0���� ���ڸ� ���� �� �������?");
		} else if(exceptObj instanceof IllegalArgumentException) {
			System.out.println("0�� ���� ����� ���� �����.");
		} else if(exceptObj instanceof SQLException) {
			System.out.println("SQL ������ ������ �ֳ׿�.");
		} else {
			System.out.println("���� �޽��� : " + exceptObj.getMessage());
		}
	}
}
