package com.sist.web.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity(name="food_house")
@Data
public class FoodEntity {
	private int fno;
	private int jjimcount, likecount, hit;
	private String poster, name, type, address, phone, theme, price, time, seat, content;
	private double score;
}
