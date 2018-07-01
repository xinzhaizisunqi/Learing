package com.qige.utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.qige.utils.domain.Person;
import com.qige.utils.service.DateFormatTest;
@SpringBootApplication 
public class Application implements CommandLineRunner{
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    @Autowired
    private DateFormatTest dateFormatTest;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Person person = new Person();
		person.setId("1");
		person.setName("sunqi");
		dateFormatTest.insertDemo(person);
	}

}