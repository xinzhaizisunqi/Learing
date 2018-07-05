package com.qige.method;

import java.lang.reflect.Method;

/**
 * 方法信息
 *
 */
public class MethodInfo {
	
	private Method method;
	
	
	private String annotionValue;
	
	

	public MethodInfo(Method method, String annotionValue) {
		super();
		this.method = method;
		this.annotionValue = annotionValue;
	}


	public MethodInfo() {
		super();
	}


	public Method getMethod() {
		return method;
	}


	public void setMethod(Method method) {
		this.method = method;
	}


	public String getAnnotionValue() {
		return annotionValue;
	}


	public void setAnnotionValue(String annotionValue) {
		this.annotionValue = annotionValue;
	}
	//获取方法名字
	public String getMethodName(){
		return this.method.getName();
	}
}
