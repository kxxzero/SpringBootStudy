package com.sist.web.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sist.web.entity.Recipe;

public interface RecipeService extends JpaRepository<Recipe, Integer>{
	@Query(value="SELECT * FROM recipe2 "
			+ "ORDER BY no ASC LIMIT 0,5", nativeQuery=true)
	public List<Recipe> recipeMainList();
	
	public Recipe findByNo(int no);
	
	@Query(value="SELECT * FROM recipe2 "
			+ "OREDER BY no ASC LIMIT :start, 12", nativeQuery=true)
	public List<Recipe> recipeListData(@Param("start") int start);
}
