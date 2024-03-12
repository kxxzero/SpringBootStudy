package com.sist.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
no int 
title text 
poster text 
chef text 
hit int
 */

@Entity(name="recipe2")
@Getter
@Setter
@NoArgsConstructor
public class Recipe {
	@Id
	private int no;
	private String title, poster, chef;
	private int hit;
}
