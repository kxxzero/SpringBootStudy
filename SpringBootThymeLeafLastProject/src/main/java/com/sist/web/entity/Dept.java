package com.sist.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
// JPA => 객체와 데이터베이스 컬럼을 매핑 => ORM
public class Dept {
	@Id
	private int deptno;
	private String dname, loc;
}
