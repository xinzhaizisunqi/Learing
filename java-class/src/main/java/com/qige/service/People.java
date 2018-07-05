package com.qige.service;

import com.qige.annotion.CollectMethod;
import com.qige.annotion.CollectTarget;

@CollectTarget
public class People {
	// use the annotion @CollectMethod ,the spring context can collect the method name
	@CollectMethod("collectGetPeopleName")
	public String getPeopleName() {
		return "sunqi";
	}
}
