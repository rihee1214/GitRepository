package com.iu.s1.board;

import org.springframework.ui.Model;

public class BoardController {

	public void boardlist(String boardsp, Model model)throws Exception{
		model.addAttribute("result", boardsp);
	}
}
