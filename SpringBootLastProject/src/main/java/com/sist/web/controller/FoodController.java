package com.sist.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.entity.Food;
import com.sist.web.service.FoodService;

@RestController
@CrossOrigin(origins = "*")
public class FoodController {
	@Autowired
	private FoodService fService;
	
	@GetMapping("/food/list_react")
	public Map food_list(int page) {
		int rowSize=12;
		int start=(rowSize*page)-rowSize;
		List<Food> list=fService.foodListData(start);
		int count=(int)fService.count();
		int totalpage=(int)(Math.ceil(count/12.0));
		
		Map map=new HashMap();
		map.put("food_list", list);
		map.put("totalpage", totalpage);
		
		return map;
	}
	
	@GetMapping("/food/find_react")
	public Map food_find(int page, String address) {
		int rowSize=12;
		int start=(rowSize*page)-rowSize;
		List<Food> list=fService.foodFindData(address, start);
		int totalpage=fService.foodFindTotalPage(address);
		Map map=new HashMap();
		map.put("find_list", list);
		map.put("totalpage", totalpage);
		
		// {find_list:[], totalpage:..}
		return map;
	}
	
	@GetMapping("/food/detail_react")
	public Food food_detail(int fno) {
		Food food=fService.findByFno(fno);
		food.setHit(food.getHit()+1); // 조회수 증가
		fService.save(food);
		food=fService.findByFno(fno);
		return food;
	}
}
