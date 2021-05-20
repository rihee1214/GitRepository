package com.iu.s1.member;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/**")
public class MemberController {

	@GetMapping("join")
	public void getJoin(Model model) {
		model.addAttribute("memberVO", new MemberVO());
	}
	
	@PostMapping("join")
	public String getJoin(@Valid MemberVO memberVO, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "member/join";
		}
		System.out.println("성공");
		return "redirect:/";
	}
}
