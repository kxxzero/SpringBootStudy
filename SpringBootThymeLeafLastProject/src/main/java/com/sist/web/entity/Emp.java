package com.sist.web.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
EMPNO int 
ENAME text 
JOB text 
MGR int 
HIREDATE text 
SAL int 
COMM text 
DEPTNO int
 */

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor // 매개변수가 없는 생성자 작성
public class Emp {
	@Id
	private int empno;
	private String ename, job, hiredate, comm;
	private int mgr, sal;
	@Column(insertable=false, updatable=false) // 참조 변수
	private int deptno;	
	
	@ManyToOne(fetch=FetchType.EAGER) // EMP 여러 개에 DEPT 한 개
	// LAZY : 지연 / EAGER : 즉시 로딩
	
	@JoinColumn(name="deptno", referencedColumnName="deptno")
	private Dept dept;
	
}
