package com.iu.s1.error;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorCotroller {

	
	@ExceptionHandler(Exception.class)
	public String getThrow(Model model) {
		model.addAttribute("msg","error");
		return "error/500";
	}
	
	@ExceptionHandler(ArithmeticException.class)
	public String getNull(Model model) {
		model.addAttribute("msg","arithmeticexeption");
		return "error/500";
	}
	
	
}
