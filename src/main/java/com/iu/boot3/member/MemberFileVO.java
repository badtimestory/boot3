package com.iu.boot3.member;

import com.iu.boot3.util.FileVO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberFileVO extends FileVO{

	/*
	  	FILENUM BIGINT AUTO_INCREMENT,
		ID VARCHAR(100),
		FILENAME VARCHAR(200),
		ORINAME VARCHAR(200),
		CONSTRAINT MF_FN_PK PRIMARY KEY(FILENUM),
		CONSTRAINT MF_ID_FK FOREIGN KEY(ID) REFERENCES MEMBER(ID) ON DELETE CASCADE
	*/
	
	// 아이디
	private String id;
}
