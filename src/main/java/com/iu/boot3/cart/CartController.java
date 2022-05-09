package com.iu.boot3.cart;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.iu.boot3.member.MemberVO;


// @Controller
// 모든 메서드가 @ResponseBody가 있으면 선언
@RestController
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@PostMapping("/cart/{ProductNum}/{count}")
//	@ResponseBody : @RestController 선언되어 있다면 생략가능
	public int setAdd(HttpSession session, @PathVariable Long ProductNum, @PathVariable Long count) throws Exception {
		System.out.println("ProductNum : " + ProductNum);
		CartVO cartVO = new CartVO();
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		cartVO.setProductNum(ProductNum);
		cartVO.setId(memberVO.getId());
		cartVO.setCount(count);
		
		int result = cartService.setAdd(cartVO);
		System.out.println("result : " + result);
		// result를 JSON 형태로 바꿔주는 라이브러리를 사용
		return result;
	}
	
	// 파라미터 값이 계속 바뀌기 때문에 변수로 선언해줌
	@GetMapping("/cart/{pn}")
	@ResponseBody
	// uri주소의 값을 매개변수에다가 대입
	public List<CartVO> getList(HttpSession session, @PathVariable Long pn) throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println("pn : " + pn);
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		
		CartVO cartVO = new CartVO();
		cartVO.setId(memberVO.getId());
		
		List<CartVO> ar =  cartService.getList(cartVO);
		System.out.println(ar);
		
		return ar;
	}
	
	@DeleteMapping("/cart/{cartNum}")
	public ModelAndView setDelete(@PathVariable Long cartNum) throws Exception {
		System.out.println("CartNum : " + cartNum);
		return null;
	}
	
}
