package com.sist.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
FNO int PK 
POSTER text 
NAME text 
TYPE text 
ADDRESS text 
PHONE text 
SCORE double 
THEME text 
PRICE text 
TIME text 
SEAT text 
CONTENT text 
LINK text 
HIT int 
JJIMCOUNT int 
LIKECOUNT int
 */

@Entity(name="food")
@Data
@NoArgsConstructor
public class Food {
	@Id
	private int fno;
	private String poster, name, type, address, phone, theme, price, time, seat, content, link;
	private double score;
	private int hit, jjimcount, likecount;
}
