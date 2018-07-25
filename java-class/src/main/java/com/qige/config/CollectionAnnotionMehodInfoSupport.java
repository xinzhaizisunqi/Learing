package com.qige.config;
import java.util.Map;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import com.qige.annotion.EnableCollectAnnotionMethodInfo;
import com.qige.method.TargetClassDefinition;



/**
 * spring boot 启动的时候 {@code} AbstractApplicationContext  的refresh()方法会走，走的过程当中
 * 会执行一些逻辑 调用registerBeanDefinitions这个方法 所以这个类在作为bean注入的时候 会执行registerBeanDefinitions
 * 方法，{@code PostProcessorRegistrationDelegate invokeBeanFactoryPostProcessors}执行一些逻辑先会执行
 * postProcessBeanDefinitionRegistry 再去执行invokeBeanFactoryPostProcessors 所以如果spring 上下文中存在
 * 实现了BeanFactoryPostProcessor接口的类 和 实现了ImportBeanDefinitionRegistrar接口的类
 * 那么一定是ImportBeanDefinitionRegistrar这个先执行
 *
 */
public class CollectionAnnotionMehodInfoSupport  implements ImportBeanDefinitionRegistrar{
	
	private static final String COLLECT_TARGET_CHECK_ANNO_ATTR_PACKAGES = "packages";
	private static final String[] DEFAULT_SCAN_PACKAGES={"com.qige"};

	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata,BeanDefinitionRegistry registry) {
		boolean flag = importingClassMetadata.hasAnnotation(EnableCollectAnnotionMethodInfo.class.getName());
		if (flag) {
			RootBeanDefinition beanDefinition = new RootBeanDefinition();
			beanDefinition.setBeanClass(TargetClassDefinition.class);
			beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
			Map<String, Object> annotationAttributes = importingClassMetadata
					.getAnnotationAttributes(EnableCollectAnnotionMethodInfo.class.getName());
			Object object = annotationAttributes.get(COLLECT_TARGET_CHECK_ANNO_ATTR_PACKAGES);
			String[] packagesNames = object == null?DEFAULT_SCAN_PACKAGES:(String[]) object;
			ConstructorArgumentValues argumentValues = new ConstructorArgumentValues();
			argumentValues.addGenericArgumentValue(packagesNames);
			beanDefinition.setConstructorArgumentValues(argumentValues);
			registry.registerBeanDefinition("targetClassDefinition", beanDefinition);
		}
	}
}
