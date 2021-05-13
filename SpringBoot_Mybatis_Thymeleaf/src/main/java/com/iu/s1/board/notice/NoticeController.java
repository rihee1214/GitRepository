package com.iu.s1.board.notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iu.s1.board.BoardVO;
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
		noticeService.setHitUpdate(noticeVO);
		model.addAttribute("select", noticeService.getSelect(noticeVO));
		return "board/select";
	}
	
	@GetMapping("insert")
	public String setInsert(Model model)throws Exception{
		model.addAttribute("ar", new BoardVO());
		model.addAttribute("sp", "insert");
		return "board/form";
	}
	
	@PostMapping("insert")
	public String setInsert(NoticeVO noticeVO)throws Exception{
		noticeService.setBoard(noticeVO);
		return "redirect:./list";
	}
	
	@GetMapping("delete")
	public String setDelete(NoticeVO noticeVO)throws Exception{
		noticeService.setDelete(noticeVO);
		return "redirect:./list";
	}
	
	@GetMapping("update")
	public String setUpdate(NoticeVO noticeVO, Model model)throws Exception{
		model.addAttribute("ar", noticeService.getSelect(noticeVO));
		model.addAttribute("sp", "update");
		return "board/form";
	}
	
	@PostMapping("update")
	public String setUpdate(NoticeVO noticeVO)throws Exception{
		noticeService.setUpdate(noticeVO);
		return "redirect:./list";
	}
}
