package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@Autowired
	private FoodService fService;
	
	@GetMapping("/")
	public String main_main(String page, Model model) {
		if(page==null) {
			page="1";
		}
		int curpage="";
	}
}
