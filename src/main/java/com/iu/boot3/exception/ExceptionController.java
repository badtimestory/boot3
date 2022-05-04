package com.iu.boot3.exception;

import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(BindException.class)
	public ModelAndView ex1(Exception e) {
		ModelAndView mv = new ModelAndView();
		System.out.println(e.getMessage());
		
		System.out.println("==============================");
		
		e.printStackTrace();
		
		System.out.println("예외 발생");
		mv.addObject("message", "불편을 드려서 죄송합니다");
		mv.addObject("path", "../");
		mv.setViewName("common/alert");
		return mv;
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView ex2() {
		ModelAndView mv = new ModelAndView();
		System.out.println("Nullpointer 예외 발생");
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
		System.out.println("throwable Exception 예외 발생");
		mv.setViewName("error/error");
		return mv;
	}
	
	// 400 error
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView ex5() {
		ModelAndView mv = new ModelAndView();
		System.out.println("4xx 예외 발생");
		mv.addObject("message", "잘못된 페이지 요청입니다");
		mv.setViewName("error/error");
		return mv;
	}
	

}
