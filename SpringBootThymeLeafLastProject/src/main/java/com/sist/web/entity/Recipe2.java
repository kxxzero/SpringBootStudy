package com.sist.web.entity;
/*
 * no bigint 
title varchar(2000) 
poster varchar(500) 
chef varchar(200) 
hit bigint
 */

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

/*
no int 
title text 
poster text 
chef text 
hit int
 */

@Entity
@Data
public class Recipe2 {
	@Id
	private int no;
	private String title;
	private String poster;
	private String chef;
	private int hit;	
}
