package cn.itcast.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyInterceptor {
	/**
	 * ��һ���ǺŴ����κεķ���ֵ���� �ڶ���������� �������ʾ���Ӱ����µ���������� �ǺŴ��������� ������ǺŴ����� �����д�����Ĳ���
	 */
	@Pointcut("execution (* cn.itcast.service.impl.PersonServiceBean.*(..))")
	private void anyMethod() {}//����һ�������	
	@Before("anyMethod() && args(name)")
	public void doAccessCheck(String name) {//����ǰ��֪ͨ
		System.out.println("ǰ��֪ͨ"+name);
	}	
	@AfterReturning(pointcut = "anyMethod()",returning="result")
	public void doAfterReturning(String result) {//�������֪ͨ
		System.out.println("����֪ͨ" + result);
	}
	@After("anyMethod()")
	public void doAfter() {
		System.out.println("����֪ͨ");
	}
	@AfterThrowing(pointcut = "anyMethod()",throwing="e")
	public void doAfterThrowing(Exception e) {
		System.out.println("����֪ͨ"+e);//throw new RuntimeException("����");		
	}
	@Around("anyMethod()")
	public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("���뷽��");
		Object result = pjp.proceed();//����֪ͨ
		System.out.println("�˳�����");
		return result;
	}
}
