package com.iu.boot3.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pager {
	
	// DB에서 한 페이지에 몇개씩 조회(파라미터의 값 가능)
	private Integer perPage;
		
	//DB에서 조회할 시작 인덱스 번호
	private Integer startRow;
	
	// 페이지 번호(Parameter value)
	private Integer pn;
	
	// ---------- 검색 변수 ----------
	
	// 검색 타입(파라미터의 값)
	private String kind;
	// 검색어(파라미터의 값)
	private String search;
	
	// ---------- JSP 변수 ----------
	
	// 시작 번호
	private Integer startNum;
	// 끝 번호
	private Integer lastNum;
	// previous
	private boolean pre;
	// next
	private boolean next;
	
	
		
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
		this.startRow = (this.getPn()-1) * this.getPerPage();	
	}
	
	// GETTER : get + 멤버변수명, 멤버변수명의 첫글자는 대문자
	public String getSearch() {
		if(this.search == null) {
			this.search = "";
		}
		
		return this.search;
	}
	
	public void makeNum(int totalCount) {
		// 전체 row의 갯수
		System.out.println("Board Table의 총 Row 갯수: " + totalCount);
		
		// 전체 페이지
		Integer totalPage = totalCount / this.getPerPage();
		// getPerPage로 나눈 갯수보다 많을 때 하나 더 생성
		if(totalCount % this.getPerPage() != 0) {
			totalPage++;
		}
		
		// 페이징번호 10개씩 출력
		Integer perBlock = 10;
		
		// 전체 blcok
		Integer totalBlock = totalPage / perBlock;
		if(totalPage % perBlock != 0) {
			totalBlock++;
		}
		
		// 현재 block
		Integer curBlock = this.getPn() / perBlock;
		if(this.getPn() % perBlock != 0) {
			curBlock++;
		}
		
		// startNum
		this.startNum = (curBlock-1) * perBlock+1;
		
		// lastNum
		this.lastNum = curBlock * perBlock;
		
		// previous
		if(curBlock > 1) {
			this.pre = true;
		}
		
		// next
		if(totalBlock > curBlock) {
			this.next = true;
		}
		
		if(curBlock == totalBlock) {
			this.lastNum = totalPage;
		}
	}
}
