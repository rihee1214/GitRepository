package com.iu.s1.board.notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iu.s1.util.Pager;

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
	public String getList(Pager pager, Model model)throws Exception{
		pager.makeRow(noticeService.getTotalCount(pager));
		model.addAttribute("list", noticeService.getList(pager));
		model.addAttribute("pager", pager);
		return "board/list";
	}
	
	@GetMapping("select")
	public String getSelect(NoticeVO noticeVO, Model model)throws Exception{
		model.addAttribute("select", noticeService.getSelect(noticeVO));
		return "board/select";
	}
	
	@GetMapping("insert")
	public String setInsert()throws Exception{
		return "board/insert";
	}
	
	@PostMapping("insert")
	public String setInsert(NoticeVO noticeVO)throws Exception{
		noticeService.setBoard(noticeVO);
		return "redirect:/notice/list";
	}
}
