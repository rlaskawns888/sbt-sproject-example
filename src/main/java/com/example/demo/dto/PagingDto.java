package com.example.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PagingDto {
	private Integer pageNo; //페이지번호
	private Integer pageSize; //한페이지당 조회할 갯수
//	private String sortBy; //순서.
	
	public PagingDto(Integer pageNo, Integer pageSize) {
		super();
		this.pageNo = pageNo;
		this.pageSize = 10;
	}
		
}
