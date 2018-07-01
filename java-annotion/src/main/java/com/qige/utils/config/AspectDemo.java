package com.qige.utils.config;
import java.lang.reflect.Field;
import java.util.Date;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.qige.utils.annotion.DateFormat;

@Aspect
@Component
public class AspectDemo {
	
	@Pointcut("execution(* com.qige.utils.service..*.*(..))")
    public void before(){}

	@Before("before()")
	public void before(JoinPoint   joinPoint) throws Throwable {
		 //访问目标方法的参数：
        Object[] args = joinPoint.getArgs();
        Object returnValue = args[0];
        Class<?> clazz =returnValue.getClass();
        Field[] fields = clazz.getDeclaredFields();  
	    //循环实体类字段集合,获取标注@ColumnConfig的字段  
	    for (Field field : fields) {  
	    	 if(field.isAnnotationPresent(DateFormat.class)){ 
	    		 DateFormat  anno = field.getAnnotation(DateFormat.class);
	    		 String format = anno.value();
	    		 System.out.print(format);
	    		 field.setAccessible(true);
	    		 field.set(returnValue, new Date());
	    	 }
	    }
	}

}
