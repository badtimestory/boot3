package com.iu.boot3.member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@ModelAttribute("board")
	public String Board() {
		return "member";
	}
	
	@GetMapping("signUp")
	public String signUp(Model model, MemberVO memberVO) throws Exception {
		
		model.addAttribute("vo", memberVO);
		
		return "member/signUp";
	}
	
	@PostMapping("signUp")
	public String signUp(Model model, MemberVO memberVO, MultipartFile file) throws Exception {
			int result = memberService.signUp(memberVO, file);
		
			model.addAttribute("vo", memberVO);
			
			return "redircet:/";
	}
	
	@GetMapping("login")
	public String login() throws Exception {
		
		return "member/login";
	}
	
	@PostMapping("login")
	public String login(HttpSession session, MemberVO memberVO) throws Exception {
		memberVO = memberService.login(memberVO);
		String viewPath = "member/login";
		
		if(memberVO != null) {
			session.setAttribute("member", memberVO);
			viewPath = "redirect:../";
		}
		
		return viewPath;
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) throws Exception {
		session.invalidate();
		
		return "redirect:../";
	}
	
	@GetMapping("myPage")
	public String myPage(HttpSession session, Model model) throws Exception {
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		memberVO = memberService.myPage(memberVO);
		model.addAttribute("vo", memberVO);
		return "member/myPage";
	}
	
	// 회원정보 수정
	@GetMapping("update")
	public String memberUpdate(HttpSession session, Model model) throws Exception {
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		memberVO = memberService.myPage(memberVO);
		model.addAttribute("vo", memberVO);
		return "member/update";
	}
	
	@PostMapping("update")
	public String memberUpdate(Model model, MemberVO memberVO, HttpSession session) throws Exception {
		MemberVO vo = (MemberVO)session.getAttribute("member");
		memberVO.setId(vo.getId());
		int result = memberService.memberUpdate(memberVO);
		model.addAttribute("vo", memberVO);
		return "redirect:./myPage";
	}
	
	// 멤버 탈퇴
	@GetMapping("delete")
	public String memberDelete(HttpSession session) throws Exception {
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		int result = memberService.memberDelete(memberVO);
		// 세션 삭제
		session.invalidate();
			
		return "redirect:../";
		
	}
	
}
