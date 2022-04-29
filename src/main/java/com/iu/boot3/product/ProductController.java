package com.iu.boot3.product;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

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
	
	@GetMapping("detail")
	public String getDetail(Model model, ProductVO productVO, Pager pager) throws Exception {
		// parameter는 productNum
		// 모든 구매자가 보는 페이지
		productVO = productService.getDetail(productVO);
		model.addAttribute("vo", productVO);
		model.addAttribute("pager", pager);
		
		return "product/detail";
	}
	
	@GetMapping("manageDetial")
	public String getManageDetail(Model model, ProductVO productVO) throws Exception {
		// parameter는 productNum
		// 모든 판매자가 보는 페이지
		
		return "product/manageDetail";
	}
	
	@GetMapping("add")
	public String setAdd() throws Exception {
		
		return "product/add";
	}
	
	@PostMapping("add")
	public String setAdd(Model model, ProductVO productVO, MultipartFile[] files, 
			HttpSession session) throws Exception {
		
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		productVO.setId(memberVO.getId());
		
		for(MultipartFile f: files) {
			System.out.println("원본파일이름: " + f.getOriginalFilename());
			System.out.println("파일 크기: " + f.getSize());
		}
		
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

}
