package com.sist.web.entity;
// 원하는 컬럼의 데이터만 가져오고 싶을 때는 인터페이스 사용 => 인터페이스는 무조건 public

public interface FoodListVO {
	public int getFno();
	public String getName();
	public String getPoster();
}
