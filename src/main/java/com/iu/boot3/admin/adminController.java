package com.iu.boot3.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/*")
public class adminController {
	
	@GetMapping
	public String adminManage() throws Exception {
		
		return "admin/manage";
	}

}
