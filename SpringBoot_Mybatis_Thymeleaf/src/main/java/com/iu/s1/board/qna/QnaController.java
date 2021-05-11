package com.iu.s1.board.qna;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/qna/**")
public class QnaController {

	@ModelAttribute("board")
	public String getBoard() {
		return "Qna";
	}
	
	@GetMapping("list")
	public String getList()throws Exception{
		return "board/list";
	}
}
