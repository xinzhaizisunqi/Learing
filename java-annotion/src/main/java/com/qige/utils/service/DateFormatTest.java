package com.qige.utils.service;
import org.springframework.stereotype.Component;
import com.qige.utils.domain.Person;

@Component
public class DateFormatTest {

	public void insertDemo(Person person) {
		
		System.out.print(person.getBirthday());
		
		
	}

}
