package com.sist.web.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.Data;

/*
no int AI PK 
name varchar(51) 
subject varchar(1000) 
content text 
pwd varchar(10) 
regdate datetime 
hit int
 */

@Entity
@Data
@DynamicUpdate
public class Board {
	@Id // 자동 증가 번호
	private int no;
	private String name;
	private String subject;
	
	@Column(insertable=true, updatable=false) // update 불가
	private String pwd;
	
	private String content;
	
	@Column(insertable=true, updatable=false)
	private String regdate;
	
	private int hit;
	
	@PrePersist // 변경
	public void regdate() {
		this.regdate=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
	}
}
