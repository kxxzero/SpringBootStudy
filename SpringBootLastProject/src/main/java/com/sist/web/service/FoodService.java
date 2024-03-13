package com.sist.web.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.sist.web.entity.Food;

@Service
public interface FoodService extends JpaRepository<Food, Integer>{
	@Query(value="SELECT * FROM food "
			+ "ORDER BY fno ASC LIMIT 0, 8", nativeQuery=true)
	public List<Food> foodMainData();
	
	public Food findByFno(int fno);
	
	@Query(value="SELECT * FROM food "
			+ "ORDER BY fno ASC LIMIT :start, 12", nativeQuery=true)
	public List<Food> foodListData(@Param("start") int start);
	
	// 검색 목록
	@Query(value="SELECT * FROM food "
			+ "WHERE address LIKE CONCAT('%',:address,'%') "
			+ "ORDER BY fno ASC LIMIT :start, 12", nativeQuery=true)
	public List<Food> foodFindData(@Param("address") String address, @Param("start") int start);
	
	// 검색 결과 총 페이지
	@Query(value="SELECT CEIL(COUNT(*)/12.0) FROM food "
			+ "WHERE address LIKE CONCAT('%',:address,'%')")
	public int foodFindTotalPage(@Param("address") String address);
}
