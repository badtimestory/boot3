package com.iu.boot3.board;

import java.sql.Date;
import java.util.List;

import lombok.Data;

@Data
public class BoardVO {
	
	/*
	 
		NUM BIGINT AUTO_INCREMENT,
		TITLE VARCHAR(200), 
		WRITER VARCHAR(200),
		CONTENTS TEXT,
		HIT BIGINT,
		REGDATE DATE,	
		REF BIGINT,
		STEP BIGINT,
		DEPTH BIGINT,
		CATEGORY INT,	
		CONSTRAINT BOARD_NUM_PK PRIMARY KEY (NUM)
	  
	*/
	
	private Long num;
	private String title;
	private String writer;
	private String contents;
	private Long hit;
	private Date regDate;
	private Long ref;
	private Long step;
	private Long depth;
	private Integer categoty;
	
	private List<BoardFilesVO> filesVOs;
	
}
