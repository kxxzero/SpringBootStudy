package com.sist.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

/*
CNO bigint 
CHEF varchar(100) 
POSTER varchar(500) 
MEM_CONT1 bigint 
MEM_CONT2 bigint 
MEM_CONT3 bigint 
MEM_CONT7 bigint
 */

@Entity
@Data // @getter/@setter 따로 입력하는 것보다 @data 입력 시 생성자까지 처리
public class Chef {
	@Id
	private int cno;
	private String chef, poster;
	private int mem_cont1, mem_cont2, mem_cont3, mem_cont7;
}
