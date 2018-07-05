package com.qige.method;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import com.qige.annotion.CollectMethod;
import com.qige.annotion.CollectTarget;
import com.qige.utils.AnnotatedTypeScanner;

/**
 * 
 *
 */
public class TargetClassDefinition {

	private Set<Class<?>> checkerClass;

	private List<MethodInfo> methodInfos = new ArrayList<>();

	private String[] packageNames;

	public TargetClassDefinition(final String[] packageNames) {
		this.packageNames = packageNames;
	}

	@PostConstruct
	public void initCheckerHandler() {
		Set<Class<?>> checkerClasses = findSecurityTargetCheckerClasses();
		this.checkerClass = checkerClasses;
		for (Class<?> collClass : checkerClasses) {
			Method[] methods = collClass.getDeclaredMethods();
			for (Method method : methods) {
				method.setAccessible(true);
				if(method.isAnnotationPresent(CollectMethod.class)) {
					String annotionValue = method.getAnnotation(CollectMethod.class).value();
					MethodInfo methodInfo = new MethodInfo(method,annotionValue);
					this.methodInfos.add(methodInfo);
					
				}
			}
		}
	}

	private Set<Class<?>> findSecurityTargetCheckerClasses() {
		Set<Class<?>> scannedTypes = new HashSet<Class<?>>();
		AnnotatedTypeScanner annotatedTypeScanner = new AnnotatedTypeScanner(
				CollectTarget.class);
		Set<Class<?>> annotatedTypes = annotatedTypeScanner
				.findTypes(this.packageNames);
		scannedTypes.addAll(annotatedTypes);
		return scannedTypes;
	}
	

	public List<MethodInfo> getMethodInfos() {
		return methodInfos;
	}

	public Set<Class<?>> getCheckerClass() {
		return checkerClass;
	}

	public void setCheckerClass(Set<Class<?>> checkerClass) {
		this.checkerClass = checkerClass;
	}

	public String[] getPackageNames() {
		return packageNames;
	}

	public void setPackageNames(String[] packageNames) {
		this.packageNames = packageNames;
	}

	public void setMethodInfos(List<MethodInfo> methodInfos) {
		this.methodInfos = methodInfos;
	}
}
