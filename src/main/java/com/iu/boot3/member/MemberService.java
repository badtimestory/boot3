package com.iu.boot3.member;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
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
	
	// 회원가입
	public int signUp(MemberVO memberVO, MultipartFile file) throws Exception {
		
		int result = memberMapper.signUp(memberVO);
		
		// memberrole table insert
		Map<String, String> map = new HashMap<>();
		map.put("id", memberVO.getId());
		map.put("roleName", memberRole);
		
		result = memberMapper.setRoleAdd(map);
		
		if(!file.isEmpty()) {
			String fileName = filemanager.fileSave(file, "resources/upload/member/");
			
			MemberFileVO memberFileVO = new MemberFileVO();
			memberFileVO.setId(memberVO.getId());
			memberFileVO.setFileName(fileName);
			memberFileVO.setOriName(file.getOriginalFilename());
			// memberFiles 테이블에 저장
			memberMapper.setAddFile(memberFileVO);
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
}
