package com.fang.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test {

	private static Logger logger=LoggerFactory.getLogger(Test.class);
	
	@RequestMapping(value="/test.do")
	public String test(){
		logger.info("start");
		return "main";
	}
}
