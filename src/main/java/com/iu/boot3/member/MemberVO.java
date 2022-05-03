package com.iu.boot3.member;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

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
	@NotBlank(message = "ID는 필수입니다.")
	private String id;
	private String checkId;
	
	// 비밀번호
	@Size(min = 3, max = 8, message = "PW는 3자 이상 8자 이하")
	private String pw;
	// 비밀번호 체크
	private String checkPw;
	
	// 이름
	@NotBlank(message = "이름을 입력하세요")
	private String name;
	// 이메일
	@Email(message = "이메일 형식에 맞게 입력하세요")
	@NotBlank
	private String email;
	// 전화번호
	private String phone;
	
	// 첨부파일
	private MemberFileVO memberFileVO;
	
	private List<RoleVO> roleVOs;

}
