package com.qige.annotion;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;



/** 
 * wirte on a method,when the spring runing ,
 * the spring context can registry a bean ,
 * the bean contains classinfo and methodinfo for the annotion 
 */
@Target(value=ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface CollectMethod {
	
	String value() default "";

}
