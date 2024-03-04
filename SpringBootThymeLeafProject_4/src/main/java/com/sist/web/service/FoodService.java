package com.sist.web.service;

public interface FoodService extends JpaRepository<FoodEntity, Integer> {
	@Query(value="SELECT * FROM food_house "
			+ "ORDER BY fno ASC LIMIT : start, 12", nativeQuery=true) // nativeQuery=true : 문장을 그대로(작성한대로) 수행
	public List<FoodEntity> foodListData();
}
