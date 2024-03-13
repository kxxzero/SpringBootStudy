package com.sist.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// ORM => 데이터베이스 컬럼 => 객체의 멤버 변수 매칭 => 자동 SQL
@Entity(name="food")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Food {
	// Id : 자동 증가 번호 => insert, update, delete 
	@Id
	private int fno;
	private String poster, name, type, address, phone, theme, price, time, seat, content, link;
	private double score;
	private int hit, jjimcount, likecount;
}
