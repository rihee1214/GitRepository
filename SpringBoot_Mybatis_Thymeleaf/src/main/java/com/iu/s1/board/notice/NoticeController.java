package com.iu.s1.board.notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	@ModelAttribute("board")
	public String getBoard() {
		return "Notice";
	}
	
	@GetMapping("list")
	public String getList(Model model)throws Exception{
		model.addAttribute("list", noticeService.getList());
		return "board/list";
	}
	
	@GetMapping("select")
	public String getSelect(NoticeVO noticeVO, Model model)throws Exception{
		model.addAttribute("select", noticeService.getSelect(noticeVO));
		return "board/select";
	}
}
