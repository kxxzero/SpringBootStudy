package com.sist.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.entity.Food;
import com.sist.web.entity.Recipe;
import com.sist.web.service.FoodService;
import com.sist.web.service.RecipeService;

@RestController
@CrossOrigin(origins = "*")
public class MainController {
	@Autowired
	private FoodService fService;
	
	@Autowired
	private RecipeService rService;
	
	@GetMapping("/")
	public List<Food> foodMainData() {
		List<Food> list=fService.foodMainData();
		for(Food vo:list) {
			vo.setPoster("http://www.menupan.com"+vo.getPoster());
		}
		return list;
	}
	
	@GetMapping("/main")
	public Food foodMainVO() {
		Food food=fService.findByFno(180);
		return food;
	}
	
	@GetMapping("/recipe/main")
	public List<Recipe> recipeMainList(){
		return rService.recipeMainList(); // list 대신 바로 변수를 return 해도 됨
	}
}
