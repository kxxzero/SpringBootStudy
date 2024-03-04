package com.sist.vo;

import lombok.Data;

@Data
public class FoodVO {
	private int fno, hit;
	private String poster, name, type, address, phone, theme, price, time, seat;
	private double score;
}
