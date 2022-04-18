package com.iu.boot3.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pager {
	
	// DB에서 한 페이지에 몇개씩 조회
	private Integer perPage;
	
	//DB에서 조회할 시작 인덱스 번호
	private Integer startRow;
	
	// 페이지 번호(Parameter value)
	private Integer pn;
	
	// ---------- 검색 변수 ----------
	
	// 검색 타입
	private String searchType;
	// 검색어
	private String keyWord;
		
	public Integer getPerPage() {
		// null이거나 음수일 때
		if(this.perPage == null || this.perPage < 1) {
			this.perPage = 10;
		}
		return this.perPage;
	}
	
	public Integer getPn() {
		// null이거나 음수일 때
		if(this.pn == null || this.pn < 1) {
			this.pn = 1;
		}
		return this.pn;
	}
	
	public void makeRow() {
		// pn : 1, perPage : 10 ==> startRow : 0
		// pn : 2, perPage : 20 ==> startRow : 10
		// pn : 3, perPage : 30 ==> startRow : 20
		
		this.startRow = (this.getPn()-1) * this.getPerPage();
		
	}
}
