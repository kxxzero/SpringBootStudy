package com.sist.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.dao.FoodDAO;
import com.sist.web.entity.Food;

@RestController
@CrossOrigin(origins="*")
public class FoodRestController {
	@Autowired
	private FoodDAO dao;	
	
	@RequestMapping("/food/find_react")
	public List<Food> foodFind(int page, String address) {
		int rowSize=12;
		int start=(rowSize*page)-rowSize;
	   	List<Food> list=dao.foodFindData(start, address);
		return list;
	}
	
	@GetMapping("food/find_totalpage_react")
	public String find_totalpage(String address) {
		int total=dao.foodFindTotalPage(address);
		return String.valueOf(total);
	}
	
	@GetMapping("/food/list_react")
	public List<Food> foodList(int page) {
		System.out.println("page:"+page);
		int rowSize=12;
		int start=(rowSize*page)-rowSize;
		List<Food> list=dao.foodListData(start);
		
		return list; //respone.data
	}
	
	@GetMapping("food/food_totalpage_react")
	public String food_totalpage() {
		int total=dao.foodListTotalPage();
		return String.valueOf(total);
	}
	
	@GetMapping("food/food_detail_react")
	public Food food_detail(int fno) {
		Food vo=dao.findByFno(fno);
		return vo;
	}
}
