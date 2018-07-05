package com.qige;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.qige.annotion.EnableCollectAnnotionMethodInfo;
import com.qige.method.MethodInfo;
import com.qige.method.TargetClassDefinition;

@SpringBootApplication
@EnableCollectAnnotionMethodInfo(packages="com.qige")
public class Application  implements CommandLineRunner{
	@Autowired
	private TargetClassDefinition targetClassDefinition;
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		List<MethodInfo> methodInfos = targetClassDefinition.getMethodInfos();
		methodInfos.forEach(n -> System.out.println(n.getMethodName() + "--------AND-------" + n.getAnnotionValue()));
	}

}
