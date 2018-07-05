package com.qige.service;

import com.qige.annotion.CollectMethod;
import com.qige.annotion.CollectTarget;

@CollectTarget
public class People {
	@CollectMethod("collectGetPeopleName")
	public String getPeopleName() {
		return "sunqi";
	}
}
