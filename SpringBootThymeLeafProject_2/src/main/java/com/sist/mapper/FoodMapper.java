package com.sist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.sist.vo.FoodVO;

@Repository
@Mapper
public interface FoodMapper {
	/*
  		<select id="foodListData" resultType="FoodVO" parameterType="int">
        SELECT fno, poster, name, price
        FROM food_house
        ORDER BY fno ASC
        LIMIT #{start}, 12
      </select>
	 */
	public List<FoodVO> foodListData(int start);
	
	/*
	 		<select id="foodTotalPage" resultType="int">
    		SELECT CEIL(COUNT(*)/12.0) FROM food_house
  		</select>
	 */
	public int foodTotalPage();
}
