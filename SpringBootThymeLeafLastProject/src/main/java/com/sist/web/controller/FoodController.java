package com.sist.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.web.dao.FoodDAO;
import com.sist.web.entity.Food;
import com.sist.web.entity.FoodListVO;

@Controller
public class FoodController {
	@Autowired
	private FoodDAO dao;
	
	@GetMapping("/food/list") // get과 post를 동시 처리 (405 출력 시 get/post 방식 오류)
	public String food_list(String page, Model model) {
		if(page==null) {
			page="1";
		}
		int curpage=Integer.parseInt(page);
		int rowSize=20;
		int start=(rowSize*curpage)-rowSize;
		List<FoodListVO> list=dao.foodListData(start);
		int totalpage=dao.foodTotalPage();
		
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage>totalpage) {
			endPage=totalpage;
		}
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("list", list);
		model.addAttribute("main_html", "food/list");
		return "main";
	}
	
	
	@GetMapping("/food/detail")
	public String food_detail(int fno, Model model) {
		Food vo=dao.findByFno(fno);
		model.addAttribute("vo", vo);
		model.addAttribute("main_html", "food/detail");
		return "main";
	}
	
	
	@RequestMapping("/food/find")
	public String food_find(String page, String address, Model model) {
		if(address==null) {
			address="마포"; // 기본값 부여
		}
		if(page==null) {
			page="1";
		}
		int curpage=Integer.parseInt(page);
		int rowSize=20;
		int start=(rowSize*curpage)-rowSize;
		List<FoodListVO> list=dao.foodFindData(start, address);
		int totalpage=dao.foodFindTotalPage(address);
		
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage>totalpage) {
			endPage=totalpage;
		}
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("list", list);
		model.addAttribute("address", address);
		model.addAttribute("main_html", "food/find");
		return "main";
	}
}
