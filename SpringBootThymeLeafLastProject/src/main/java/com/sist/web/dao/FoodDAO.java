package com.sist.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sist.web.entity.Food;
import com.sist.web.entity.FoodListVO;

public interface FoodDAO extends JpaRepository<Food, Integer>{
	@Query(value="SELECT fno, name, poster "
			+ "FROM food_house ORDER BY fno ASC "
			+ "LIMIT :start, 20", nativeQuery=true) // nativeQuery : 있는 그대로 사용
	public List<FoodListVO> foodListData(@Param("start") int start);
	
	@Query(value="SELECT CEIL(COUNT(*)/20.0) FROM food_house", nativeQuery=true)
	public int foodTotalPage();
	
	public Food findByFno(int fno);
	
	/*
	 * 	1. 일반 SQL => 데이터베이스
	 * 	2. JPQL(JOIN) => Entity 클래스
	 * 	3. 메소드 규칙
	 * 
	 * *** JPA => ORM (오브젝트와 데이터를 연결 => 데이터베이스와 Entity 객체 매핑) => 컬럼명과 개수가 반드시 일치해야 함
	 */
	
	@Query(value="SELECT fno, name, poster "
			+ "FROM food_house WHERE address LIKE CONCAT('%',:address,'%') "
			+ "LIMIT :start, 20", nativeQuery=true) // nativeQuery : 있는 그대로 사용
	public List<FoodListVO> foodFindData(@Param("start") Integer start, @Param("address") String address);
	
	@Query(value="SELECT CEIL(COUNT(*)/20.0) FROM food_house "
			+ "WHERE address LIKE CONCAT('%',:address,'%')", nativeQuery=true)
	public int foodFindTotalPage(@Param("address") String address);

}
