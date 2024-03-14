package com.sist.web.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.sist.web.entity.Recipedetail;

@Service
public interface RecipedetailService extends JpaRepository<Recipedetail, Integer>{

	public Recipedetail findByNo(int no);
}