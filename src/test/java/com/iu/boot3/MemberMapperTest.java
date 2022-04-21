package com.iu.boot3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.iu.boot3.member.MemberMapper;
import com.iu.boot3.member.MemberVO;

@SpringBootTest
class MemberMapperTest {
	
	@Autowired
	private MemberMapper memberMapper;
	
	// 회원가입 테스트
	// @Test
	void signUpTest() throws Exception {
		MemberVO memberVO = new MemberVO();
		memberVO.setId("id1");
		memberVO.setPw("1234");
		memberVO.setName("test");
		memberVO.setEmail("test@gmail.com");
		memberVO.setPhone("010-1423-5867");
		int result = memberMapper.signUp(memberVO);

		assertEquals(1, result);
	}
	
	// 로그인 테스트
	// @Test
	void loginTest() throws Exception {
		MemberVO memberVO = new MemberVO();
		memberVO.setId("id1");
		memberVO.setPw("1234");
		
	}
	

}
