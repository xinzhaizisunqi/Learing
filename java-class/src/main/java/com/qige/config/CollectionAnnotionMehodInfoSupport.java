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
