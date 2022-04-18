package com.iu.boot3.board;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardFilesVO {
	
	/*
		FILENUM BIGINT AUTO_INCREMENT,
		NUM BIGINT,
		FILENAME VARCHAR(200),
		ORINAME VARCHAR(200),
	*/

	private Long fileNum;
	private Long num;
	private String fileName;
	private String oriName;
}
