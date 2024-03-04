package com.sist.web.entity;

// DAO 작성 시 특정 컬럼을 선택해서 가져오고 싶을 때 인터페이스를 생성해서 getter/setter 부여
public interface RecipeData {
	public String getNo();
	public String getTitle();
	public String getPoster();
}
