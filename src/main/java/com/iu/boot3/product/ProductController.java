package com.iu.boot3.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

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
	
	@GetMapping("add")
	public String setAdd() throws Exception {
			
		return "product/add";
	}
	
	@PostMapping("add")
	public String setAdd(ProductVO productVO, MultipartFile[] files) throws Exception {
		int result = productService.setAdd(productVO, files);
		
		return "redirect:./list";
	}

}