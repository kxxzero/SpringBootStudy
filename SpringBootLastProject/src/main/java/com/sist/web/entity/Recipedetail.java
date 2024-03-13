package com.sist.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity // 실제 테이블명과 해당 클래스명이 일치할 경우 name 생략 가능 / 다를 경우 name을 통해 이름 부여
@Getter
@Setter
@NoArgsConstructor
public class Recipedetail {
	@Id
	private int no;
	private String poster, title, chef, chef_poster, chef_profile, info1, info2, info3, content, foodmake, stuff;
}
