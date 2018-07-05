package com.qige.annotion;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.springframework.context.annotation.Import;
import com.qige.config.CollectionAnnotionMehodInfoSupport;



/**
 * write on spring application
 *
 */
@Import(value=CollectionAnnotionMehodInfoSupport.class)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface EnableCollectAnnotionMethodInfo {
	
	String[] packages() default {};

}
