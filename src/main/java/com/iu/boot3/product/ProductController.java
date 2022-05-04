package com.iu.boot3.product;

import java.util.InputMismatchException;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.boot3.member.MemberVO;
import com.iu.boot3.util.Pager;

@Controller
@RequestMapping("/product/*")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@ModelAttribute("board")
	public String getBoard() {
		return "product";
	}
	
	@GetMapping("list")
	public String getList(Model model, Pager pager) throws Exception {
		List<ProductVO> ar = productService.getList(pager);
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		
		return "product/list";
	}
	
	// 모든 구매자가 보는 페이지
	@GetMapping("detail")
	public String getDetail(Model model, ProductVO productVO) throws Exception {
		// parameter는 productNum
		productVO = productService.getDetail(productVO);
		model.addAttribute("vo", productVO);
		
		return "product/detail";
	}
	
	// 모든 판매자가 보는 페이지
	@GetMapping("manageDetail")
	public String getManageDetail(Model model, ProductVO productVO) throws Exception {
		// parameter는 productNum
		productVO = productService.getDetail(productVO);
		model.addAttribute("vo", productVO);
		
		return "product/manageDetail";
	}
	
	@GetMapping("add")
	public String setAdd(@ModelAttribute ProductVO productVO) throws Exception {
		
		return "product/add";
	}
	
	@PostMapping("add")
	public String setAdd(Model model, @Valid ProductVO productVO, BindingResult bindingResult, 
			MultipartFile[] files, HttpSession session) throws Exception {
		
		if(bindingResult.hasErrors()) {
			return "product/add";
		}
		
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		productVO.setId(memberVO.getId());
				
		int result = productService.setAdd(productVO, files);
		
		model.addAttribute("result", result);
		
		// 동기형식일 때
		// return "redirect:./list";
		return "common/result";
	}
	
	@GetMapping("ajaxList")
	public String getAjaxList(HttpSession session, Model model, Pager pager) throws Exception {
		
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		pager.setId(memberVO.getId());
		
		List<ProductVO> ar = productService.getList(pager);
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		
		return "common/productList";
	}
	
	@GetMapping("manage")
	public String manage(HttpSession session, Model model, Pager pager) throws Exception {
		
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		pager.setId(memberVO.getId());
				
		List<ProductVO> ar = productService.getList(pager);
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);			
		
		
		return "product/manage";
	}
	
	@GetMapping("update")
	public String setUpdate(Model model, ProductVO productVO) throws Exception {
		productVO = productService.getDetail(productVO);
		model.addAttribute("vo", productVO);
				
		return "product/update";
	}
	
	@PostMapping("update")
	public ModelAndView setUpdate(Model model, ProductVO productVO, MultipartFile[] files) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		int result = productService.setUpdate(productVO, files);
		
		if(result > 0) {
			mv.setViewName("redirect:./manage");
		} else {
			mv.setViewName("common/getResult");
			mv.addObject("msg", "Update Fail");
			mv.addObject("path", "./manageDetail?productNum="+productVO.getProductNum());
		}
		return mv;
	}
	
	// 파일 삭제
	@PostMapping("fileDelete")
	public String setFileDelete(Model model, ProductFilesVO productFilesVO) throws Exception {
		
		int result = productService.setFileDelete(productFilesVO);
		
		model.addAttribute("result", result);
		
		return "common/result";
	}
	
	//	--------------------------------------------------
	//	예외처리 메서드
	//	--------------------------------------------------
	
/*	
	@ExceptionHandler(BindException.class)
	public ModelAndView ex1() {
		ModelAndView mv = new ModelAndView();
		System.out.println("예외 발생");
		mv.setViewName("error/error");
		return mv;
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView ex2() {
		ModelAndView mv = new ModelAndView();
		System.out.println("Nullpointer예외 발생");
		mv.setViewName("error/error");
		return mv;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView ex3() {
		ModelAndView mv = new ModelAndView();
		System.out.println("Exception 예외 발생");
		mv.setViewName("error/error");
		return mv;
	}
	
	@ExceptionHandler(Throwable.class)
	public ModelAndView ex4() {
		ModelAndView mv = new ModelAndView();
		System.out.println("Exception 예외 발생");
		mv.setViewName("error/error");
		return mv;
	}
	
*/

}
