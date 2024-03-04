package com.sist.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.Recipe2;
@Repository
public interface RecipeDAO extends JpaRepository<Recipe2, Integer>{
	// JPQL / 일반 SQL => nativeQuery = true
	// 조인 / 서브쿼리
//	@Query(value="SELECT no, title, poster, chef, hit "
//			+ "FROM recipe2 "
//			+ "ORDER BY no ASC "
//			+ "LIMIT 0, 12", nativeQuery=true)
//	public List<Recipe2> recipeMainData();
	@Query(value="SELECT * "
    	  +"FROM recipe2 ORDER BY no ASC "
    	  +"LIMIT 0,12", nativeQuery = true)
    public List<Recipe2> recipeMainData();
	
	// 찾기
	public Recipe2 findByNo(int no); // 메소드로 SQL 문장 생성
	// findByNO, findByTitle => WHERE no, WHERE title...
	// findByNOAndTitle => WHERE no AND title
	// findByNameLike => WHERE name LIKE
	
	
	// 목록 출력
	@Query(value="SELECT no, title, poster, chef, hit "
			+ "FROM recipe2 ORDER BY no ASC "
			+ "LIMIT :start, 20", nativeQuery=true)
	public List<Recipe2> recipeListData(@Param("start") int start);
	
	@Query(value="SELECT COUNT(*) FROM recipe2", nativeQuery=true)
	public int recipeRowCount();
}
