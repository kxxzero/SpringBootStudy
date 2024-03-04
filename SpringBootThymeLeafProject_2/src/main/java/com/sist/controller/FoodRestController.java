package com.sist.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.service.FoodService;
import com.sist.vo.FoodVO;

public class FoodRestController {
	@Autowired
	private FoodService fService;
	
	@GetMapping("food/list_react.do")
	public List<FoodVO> food_list(int page) {
		int rowSize=12;
		int start=(rowSize*page)-rowSize;
		List<FoodVO> list=fService.foodListData(start);
		return list;
	}
	
	@GetMapping("food/page_react.do")
	public Map food_page(int page) {
		int totalpage=fService.foodTotalPage();
		final int BLOCK=10;
		int startPage=((page-1)/BLOCK*BLOCK)+1;
		int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage) {
			endPage=totalpage;
		}
		Map map=new HashMap();
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		
		return map;
	}
}
