package com.qige;


import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;

@RestController
@RequestMapping(path = "/test")
public class TestController {

	@RequestMapping(value  = "/{name}", method = RequestMethod.GET)
	public String cerImgUpload(@PathVariable("name") String name) {
		Logger  logger = (Logger) LoggerFactory.getLogger("bussiness");
		logger.info("xierizhi");
	
		return "bbb";
	}
}
