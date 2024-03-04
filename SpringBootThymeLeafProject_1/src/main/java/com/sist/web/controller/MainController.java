package com.sist.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	@GetMapping("/")
	public String main_main(Model model) {
		model.addAttribute("msg", "ThymLeaf 구동...");
		return "main";
	}
}
