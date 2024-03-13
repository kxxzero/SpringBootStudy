package com.sist.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Entity / VO / DTO => 테이블
// Service(여러 개의 테이블을 관리) / DAO(하나의 테이블만 관리)
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
