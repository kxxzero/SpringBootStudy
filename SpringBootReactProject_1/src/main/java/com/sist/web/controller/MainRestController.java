package com.sist.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.dao.RecipeDAO;
import com.sist.web.entity.Recipe;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin(origins = "*")
public class MainRestController {

	@Autowired
	public RecipeDAO dao;
	
	@GetMapping("/")
	public String main_page(Model model, HttpServletRequest request) {
		Cookie[] cookies=request.getCookies();
		List<Recipe> cList=new ArrayList<Recipe>();
		int k=0;
		if(cookies!=null) {
			for(int i=cookies.length-1; i>=0; i--) { // 가장 최신 것부터 출력하기 위해 뒤에서부터 정렬
				if(cookies[i].getName().startsWith("recipe")) {
					if(k>8) {
						break;
					}
					String no=cookies[i].getValue();
					Recipe r=dao.findByNo(Integer.parseInt(no));
					cList.add(r);
					k++;
				}
			}
		}
		model.addAttribute("cList", cList);
		List<Recipe> list=dao.recipeMainData();
		model.addAttribute("list", list); // 확장자를 붙이면 안 됨
		return "main";
	}
}
