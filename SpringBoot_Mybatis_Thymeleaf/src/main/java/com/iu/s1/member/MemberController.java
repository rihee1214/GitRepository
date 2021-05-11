package com.iu.s1.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/**")
public class MemberController {

	@GetMapping("memberJoin")
	public void setJoin()throws Exception{
		
	}
	@GetMapping("memberLogin")
	public void login()throws Exception{
		
	}
}
