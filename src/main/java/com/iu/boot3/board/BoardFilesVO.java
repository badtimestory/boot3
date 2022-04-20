package com.iu.boot3.board;

import com.iu.boot3.util.FileVO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class BoardFilesVO extends FileVO{
	
	/*
		FILENUM BIGINT AUTO_INCREMENT,
		NUM BIGINT,
		FILENAME VARCHAR(200),
		ORINAME VARCHAR(200),
	*/

	// 게시판 글번호
	private Long num;
}
