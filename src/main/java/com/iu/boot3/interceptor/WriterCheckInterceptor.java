package com.iu.boot3.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.iu.boot3.board.BoardMapper;
import com.iu.boot3.board.BoardVO;
import com.iu.boot3.member.MemberVO;

@Component
public class WriterCheckInterceptor implements HandlerInterceptor {
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String method = request.getMethod();
		System.out.println("메서드 확인 : " + method);
		
		String num = request.getParameter("num");
		System.out.println("글 번호 출력 : " + num);
		
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(Long.parseLong(num));
		boardVO = boardMapper.getDetail(boardVO);
		
		MemberVO memberVO = (MemberVO)request.getSession().getAttribute("member");
		System.out.println("로그인 아이디 출력 : " + memberVO.getId());
		
		// 작성자와 로그인 한 사용자의 id가 일치하면 통과
		if(boardVO.getWriter().equals(memberVO.getId())) {
			return true;
		} else {
			// 일치하지 않으면 redirect로 list
			response.sendRedirect("./list");
			return false;
		}		
	}
}
	
//	@Override
//	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//			ModelAndView modelAndView) throws Exception {
//		
//		MemberVO memberVO = (MemberVO)request.getSession().getAttribute("member");
//		
//		Map<String, Object> map = modelAndView.getModel();
//		BoardVO boardVO = (BoardVO)map.get("vo");
//		
//		if(!boardVO.getWriter().equals(memberVO.getId())) {
////			modelAndView.setViewName("redirect:./list");
//			modelAndView.addObject("message", "작성자만 수정가능합니다.");
//			modelAndView.addObject("path", "./list");
//			modelAndView.setViewName("common/alert");
//			
//		}
//	}
//}
