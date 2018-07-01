package com.qige.utils.domain;

import java.io.Serializable;
import java.util.Date;

import com.qige.utils.annotion.DateFormat;

public class Person implements Serializable{

	private static final long serialVersionUID = -5030427150539815687L;

	private String id;
	
	private String name;
	@DateFormat(value = "yyyy-MM-dd HH:mm:ss")
	private Date Birthday;
	
	public Person() {
		super();
	}

	public Person(String id, String name, Date birthday) {
		super();
		this.id = id;
		this.name = name;
		Birthday = birthday;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return Birthday;
	}

	public void setBirthday(Date birthday) {
		Birthday = birthday;
	}
	
}
