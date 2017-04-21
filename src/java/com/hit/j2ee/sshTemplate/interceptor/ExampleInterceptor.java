package com.hit.j2ee.sshTemplate.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

@SuppressWarnings("serial")
public class ExampleInterceptor implements Interceptor{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("Action执行之前插入代码");
		
		//执行目标方法，调用下一个拦截器 或执行Action
		final String res = invocation.invoke();
		
		System.out.println("Action 执行后插入代码");
		
		return res;
	}

}
