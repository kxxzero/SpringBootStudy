package com.sist.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor // 생성자
public class Music {
	@Id // 자동 증가 번호
	private int mno;
	private int idcrement;
	private String title, singer, album, poster, state;
}
