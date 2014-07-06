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
	 * 第一个星号代表任何的返回值类型 第二个代表包名 两个点表示对子包低下的类进行拦截 星号代表所有类 后面的星号代表方法 括号中代表传入的参数
	 */
	@Pointcut("execution (* cn.itcast.service.impl.PersonServiceBean.*(..))")
	private void anyMethod() {}//声明一个切入点	
	@Before("anyMethod() && args(name)")
	public void doAccessCheck(String name) {//定义前置通知
		System.out.println("前置通知"+name);
	}	
	@AfterReturning(pointcut = "anyMethod()",returning="result")
	public void doAfterReturning(String result) {//定义后置通知
		System.out.println("后置通知" + result);
	}
	@After("anyMethod()")
	public void doAfter() {
		System.out.println("最终通知");
	}
	@AfterThrowing(pointcut = "anyMethod()",throwing="e")
	public void doAfterThrowing(Exception e) {
		System.out.println("例外通知"+e);//throw new RuntimeException("例外");		
	}
	@Around("anyMethod()")
	public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("进入方法");
		Object result = pjp.proceed();//环绕通知
		System.out.println("退出方法");
		return result;
	}
}
