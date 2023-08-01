package com.spring.mi;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AroundAdvisor implements MethodInterceptor {

	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object object;
		System.out.println("Before Business Logic");
		object = invocation.proceed();
		System.out.println("After Business Logic");
		return object;
	}


}
