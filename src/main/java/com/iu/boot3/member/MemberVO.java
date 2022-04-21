package com.iu.boot3.member;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberVO {
	/* 
		CREATE TABLE MEMBER(
		ID VARCHAR(100),
		PW VARCHAR(100),
		NAME VARCHAR(100),
		EMAIL VARCHAR(200),
		PHONE VARCHAR(100),
		CONSTRAINT MEMBER_ID_PK PRIMARY KEY (ID)
		);
	*/
	
	// 아이디
	private String id;
	// 비밀번호
	private String pw;
	// 이름
	private String name;
	// 이메일
	private String email;
	// 전화번호
	private String phone;
	
	// 첨부파일
	private MemberFileVO memberFileVO;

}
