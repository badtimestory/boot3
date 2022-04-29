package com.iu.boot3.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.iu.boot3.member.MemberVO;
import com.iu.boot3.member.RoleVO;

@Component
public class BoardInterceptor implements HandlerInterceptor {
	
	@Value("${member.role.member}")
	private String roleName;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("Board Interceptor");
		
		boolean check = false;
		
		// 로그인 한 사용자의 ROLE이 ROLE_SELLER라면 통과 아니면 거절
		MemberVO memberVO = (MemberVO)request.getSession().getAttribute("member");
		
		if(memberVO != null) {
			for(RoleVO roleVO : memberVO.getRoleVOs()) {
				if(roleVO.getRoleName().equals(roleName)) {
					System.out.println("권한 확인 : " + roleVO.getRoleName());
					check = true;
				}
			}			
		}
		
		// check -> false면 거절 : Servlet 코드 사용
		// check -> true면 통과
		
		if(!check) {
			// redirect : response.sendRedirect("url주소");
			// forward
			
			// mv.addObject("key", "value");
			request.setAttribute("message", "로그인이 필요합니다");
			request.setAttribute("path", "../member/login");
			
			// mv.setViewName();
			// WEB-INF/views 경로와 .jsp까지 직접 작성
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/alert.jsp");
			view.forward(request, response);
			
		}
		
		return check;
	}

}
