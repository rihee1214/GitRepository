package com.iu.s1.home;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 
 * ===============================================
 * 				ThymeLeaf Project
 * ===============================================
 *
 */
@Controller
public class HomeController {

	@GetMapping("/")
	public String home(Model model) throws Exception{
		model.addAttribute("message", "ThymeLeaf Project");
		return "index";
	}
	
	@GetMapping("/common/result")
	public void result(Model model, HttpServletRequest httpServletRequest)throws Exception{
		model.addAttribute("msg", (String)httpServletRequest.getAttribute("msg"));
		model.addAttribute("path", (String)httpServletRequest.getAttribute("path"));
	}
}
