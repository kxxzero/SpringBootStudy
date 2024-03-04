package com.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.service.FoodService;

@Controller
public class FoodController {
	private FoodService Service;
	
	@GetMapping("food/list")
	public String food)list(String page, Model model) {
		if(page==null) {
			page="1";
		}
		int curpage=Integer.parseInt(page);
		
	}
}
