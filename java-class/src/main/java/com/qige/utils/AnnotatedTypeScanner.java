package com.qige.utils;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.util.ClassUtils;


/**
 * ���ָ����ע�⼰ָ���İ� ɨ��ȫ�ֵ���
 *
 */
public class AnnotatedTypeScanner {
	private  Iterable<Class<? extends Annotation>> annotationTypess;

	/**
	 * Creates a new {@link AnnotatedTypeScanner} for the given annotation types.
	 * 
	 * @param considerInterfaces whether to consider interfaces as well.
	 * @param annotationTypes the annotations to scan for.
	 */
	@SafeVarargs
	@SuppressWarnings("unchecked")
	public AnnotatedTypeScanner(Class<? extends Annotation>... annotationTypes) {

		this.annotationTypess = Arrays.asList(annotationTypes);
	}

	public Set<Class<?>> findTypes(String... basePackages) {
		return findTypes(Arrays.asList(basePackages));
	}

	public Set<Class<?>> findTypes(Iterable<String> basePackages) {

		ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(false);

		for (Class<? extends Annotation> annotationType : annotationTypess) {
			provider.addIncludeFilter(new AnnotationTypeFilter(annotationType));
		}

		Set<Class<?>> types = new HashSet<Class<?>>();

		for (String basePackage : basePackages) {

			for (BeanDefinition definition : provider.findCandidateComponents(basePackage)) {
				try {
					types.add(ClassUtils.forName(definition.getBeanClassName(), getClass().getClassLoader()));
				} catch (ClassNotFoundException o_O) {
					throw new IllegalStateException(o_O);
				}
			}
		}
		return types;
	}

}
