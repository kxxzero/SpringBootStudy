package com.sist.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.Festival;

@Repository
public interface FestivalDAO extends JpaRepository<Festival, Integer>{
	/*
	 * @Query(value="SELECT * " + "FROM festival " + "ORDER BY no ASC " +
	 * "LIMIT 0, 12", nativeQuery=true) public List<Festival> festivalData();
	 */
	
	// 목록 출력
	@Query(value="SELECT * "
			+ "FROM festival "
			+ "ORDER BY no ASC "
			+ "LIMIT :start, 12", nativeQuery=true)
	public List<Festival> festivalListData(@Param("start") int start);
	
	// 총 페이지 수
	@Query(value="SELECT CEIL(COUNT(*)/12.0) FROM festival", nativeQuery=true)
	public int festivalRowCount();
	
	// 찾기
	public Festival findByNo(int no);
}
