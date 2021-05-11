package com.iu.s1.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.iu.s1.board.BoardVO;

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
		BoardVO boardVO = new BoardVO();
		return "index";
	}
}
