package com.sist.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sist.web.entity.Food;

public interface FoodDAO extends JpaRepository<Food, Integer> {
	@Query(value="SELECT * FROM food "
			+ "WHERE address LIKE CONCAT('%',:address,'%') "
			+ "ORDER BY fno ASC LIMIT :start, 12", nativeQuery=true)
	public List<Food> foodFindData(@Param("start") Integer start, @Param("address") String address);
	
	@Query(value="SELECT CEIL(COUNT(*)/12.0) FROM food "
			+ "WHERE address LIKE CONCAT('%',:address,'%')", nativeQuery=true)
	public int foodFindTotalPage(@Param("address") String address);
	
	// 찾기 => 상세보기
	public Food findByFno(int fno);
	
	@Query(value="SELECT * FROM food "
			+ "ORDER BY fno ASC LIMIT :start, 12", nativeQuery=true)
	public List<Food> foodListData(@Param("start") Integer start);
	
	@Query(value="SELECT CEIL(COUNT(*)/12.0) FROM food", nativeQuery=true)
	public int foodListTotalPage();
}
