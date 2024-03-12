package com.sist.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.dao.RecipeDAO;
import com.sist.web.dao.RecipedetailDAO;
import com.sist.web.entity.Recipe;
import com.sist.web.entity.Recipedetail;

@RestController
@CrossOrigin(origins = "*")
public class RecipeRestController {
	@Autowired
	private RecipeDAO dao;
	
	@Autowired
	private RecipedetailDAO rDao;
	
	@GetMapping("/recipe/list_react")
	public List<Recipe> recipeListData(int page) {
		int rowSize=12;
		int start=(rowSize*page)-rowSize;
		List<Recipe> list=dao.recipeListData(start);
		return list;
	}
	
	@GetMapping("/recipe/count_react")
	public String recipe_count() {
		int count=(int)dao.count();
		return String.valueOf(count);
	}
	
	@GetMapping("recipe/page_react")
	public String recipe_page() {
		int count=(int)dao.count();
		int total=(int)(Math.ceil(count/12.0));
		return String.valueOf(total);
	}
	
	// React는 "^"를 인식하지 못하기 때문에 images와 makes를 따로 작성
	@GetMapping("/recipe/image_react")
	public List<String> recipeImageData(int no) {
		Recipedetail r=rDao.findByNo(no);
		List<String> images=new ArrayList<String>();
		String[] fm=r.getFoodmake().split("\n");
		// ~~~~~~ ^ 이미지
		for(String s:fm) {
			String ss=s.substring(s.indexOf("^")+1);
			images.add(ss);
		}
		return images;
	}
	
	@GetMapping("/recipe/make_react")
	public List<String> recipeMakeData(int no) {
		Recipedetail r=rDao.findByNo(no);
		List<String> makes=new ArrayList<String>();
		String[] fm=r.getFoodmake().split("\n");
		// ~~~~~~ ^ 이미지
		for(String s:fm) {
			String ss=s.substring(0,s.indexOf("^"));
			makes.add(ss);
		}
		return makes;
	}	
	
	@GetMapping("/recipe/detail_react")
	public Recipedetail recipeDetailData(int no) {
		Map map=new HashMap();
		Recipedetail r=rDao.findByNo(no);
		String[] fm=r.getFoodmake().split("\n");
		List<String> make=new ArrayList<String>();
		List<String> image=new ArrayList<String>();
		
		for(String food:fm) {
			StringTokenizer st=new StringTokenizer(food,"^");
			make.add(st.nextToken());
			image.add(st.nextToken());
		}
		
		map.put("recipe", r);
		map.put("make", make);
		map.put("posters", image);
		
		return r;
	}

}
