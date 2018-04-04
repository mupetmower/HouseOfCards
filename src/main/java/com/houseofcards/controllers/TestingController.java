package com.houseofcards.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestingController {
	
	@RequestMapping("/testIndex")
	public String mockup() {
		return "IndexMockup";		
	}
	
	
	
	@RequestMapping("/allpagestemp")
	public String temp() {
		return "allpagestemplate";		
	}
	
}
