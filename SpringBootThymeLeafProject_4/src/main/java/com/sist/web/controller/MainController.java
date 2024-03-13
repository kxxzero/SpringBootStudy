package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.web.service.FoodService;

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
