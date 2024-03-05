package com.sist.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.Activity;

@Repository
public interface ActivityDAO extends JpaRepository<Activity, Integer>{
	// 목록 출력
	@Query(value="SELECT * "
			+ "FROM activity "
			+ "ORDER BY no ASC "
			+ "LIMIT :start, 12", nativeQuery=true)
	public List<Activity> activityListData(@Param("start") int start);
	
	// 총 페이지 수
	@Query(value="SELECT CEIL(COUNT(*)/12.0) FROM activity", nativeQuery=true)
	public int activityRowCount();
	
	// 찾기
	public Activity findByNo(int no);
}
