package com.iu.boot3.member;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import com.iu.boot3.util.Filemanager;

@Service
public class MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private Filemanager filemanager;
	
	// properties 파일의 member.role.member 속성값 반환
	@Value("${member.role.member}")
	private String memberRole;
	
	// 사용자 정의 검증 메서드 선언
	public boolean memberError(MemberVO memberVO, BindingResult bindingResult) throws Exception {
		boolean check = false;
		// check가 false면 검증 성공 : error 없음
		// check가 true면 검증 실패 : error 있음
		
		// 1. Annotation 기본 검증 결과
		check = bindingResult.hasErrors();
		
		// 2. Password가 일치하는지 수동 검증
		if(!memberVO.getPw().equals(memberVO.getCheckPw())) {
			check = true;
			bindingResult.rejectValue("checkPw", "member.password.notEqual");
		}
		
		// 3. ID 중복 검사
		MemberVO idCheck = memberMapper.getId(memberVO);
		if(idCheck != null) {
			check = true;
			bindingResult.rejectValue("id", "member.id.Equal");
		}
		
		return check;
		
	}
	
	// 회원가입
	public int signUp(MemberVO memberVO, MultipartFile file) throws Exception {
		
		int result = memberMapper.signUp(memberVO);
		
		// memberrole table insert
		Map<String, String> map = new HashMap<>();
		map.put("id", memberVO.getId());
		map.put("roleName", memberRole);
		
		result = memberMapper.setRoleAdd(map);
		
		if(file != null) {
			if(!file.isEmpty()) {
				String fileName = filemanager.fileSave(file, "resources/upload/member/");
				
				MemberFileVO memberFileVO = new MemberFileVO();
				memberFileVO.setId(memberVO.getId());
				memberFileVO.setFileName(fileName);
				memberFileVO.setOriName(file.getOriginalFilename());
				// memberFiles 테이블에 저장
				memberMapper.setAddFile(memberFileVO);
			}
		}
		return result;
	}
	
	// 회원수정
	public int memberUpdate(MemberVO memberVO) throws Exception {
		return memberMapper.memberUpdate(memberVO);
	}
	
	// 회원탈퇴
	public int memberDelete(MemberVO memberVO) throws Exception {
		MemberFileVO memberFileVO = memberMapper.getDetailFile(memberVO);
		
		int reuslt = memberMapper.memberDelete(memberVO);
		
		boolean fileResult = filemanager.fileDelete(memberFileVO.getFileName(), "/resources/upload/member/");
		
		return reuslt;
	}
	
	// 로그인
	public MemberVO login(MemberVO memberVO) throws Exception {
		return memberMapper.login(memberVO);
	}
	
	// 마이페이지
	public MemberVO myPage(MemberVO memberVO) throws Exception {
		return memberMapper.myPage(memberVO);
	}
	
	// 아이디 찾기
	public MemberVO getFindId(MemberVO memberVO) throws Exception {
		return memberMapper.getFindId(memberVO);
	}
}
