package com.sist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.mapper.FoodMapper;
import com.sist.vo.FoodVO;

@Service
public class FoodServiceImpl implements FoodService {
	@Autowired
	private FoodMapper mapper;

	@Override
	public List<FoodVO> foodListData(int start) {
		// TODO Auto-generated method stub
		return mapper.foodListData(start);
	}

	@Override
	public int foodTotalPage() {
		// TODO Auto-generated method stub
		return mapper.foodTotalPage();
	}
	
}
