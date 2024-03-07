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
	public Map foodFind(int page, String address) {
		int rowSize=12;
		int start=(rowSize*page)-rowSize;
		
		List<Food> list=dao.foodFindData(start, address);
		
		Map map=new HashMap();
		int totalpage=dao.foodFindTotalPage(address);
		final int BLOCK=10;
		int startPage=((page-1)/BLOCK*BLOCK)+1;
		int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage) {
			endPage=totalpage;
		}
		
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("list", list);
		
		return map;
	}
	
	
	@GetMapping("/food/list_react")
	public Map foodList(int page) {
		int rowSize=12;
		int start=(rowSize*page)-rowSize;
		
		List<Food> list=dao.foodListData(start);
		
		Map map=new HashMap();
		int count=(int)dao.count();
		int totalpage=(int)(Math.ceil(count/12.0));
		final int BLOCK=10;
		int startPage=((page-1)/BLOCK*BLOCK)+1;
		int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage) {
			endPage=totalpage;
		}
		
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("count", count);
		map.put("list", list);
		
		return map;
	}
}
