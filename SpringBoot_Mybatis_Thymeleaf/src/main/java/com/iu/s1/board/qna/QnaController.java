package com.iu.s1.board.qna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.iu.s1.board.BoardVO;
import com.iu.s1.util.Pager;

@Controller
@RequestMapping("/qna/**")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;

	@ModelAttribute("board")
	public String getBoard() {
		return "Qna";
	}
	
	@GetMapping("list")
	public String getList(Pager pager, Model model)throws Exception{
		pager.makeRow(qnaService.getTotalCount(pager));
		model.addAttribute("list", qnaService.getList(pager));
		model.addAttribute("pager", pager);
		return "board/list";
	}
	
	@GetMapping("select")
	public String getSelect(BoardVO boardVO, Model model)throws Exception{
		qnaService.setHitUpdate(boardVO);
		model.addAttribute("select", qnaService.getSelect(boardVO));
		return "board/select";
	}
	
	@GetMapping("delete")
	public String setDelete(BoardVO boardVO)throws Exception{
		qnaService.setDelete(boardVO);
		return "redirect:./list";
	}
	
	@GetMapping("insert")
	public String setInsert(BoardVO boardVO, Model model)throws Exception{
		model.addAttribute("ar", new BoardVO());
		model.addAttribute("sp", "insert");
		return "board/form";
	}
	
	@PostMapping("insert")
	public String setInsert(BoardVO boardVO, MultipartFile[] files)throws Exception{
		qnaService.setBoard(boardVO, files);
		return "redirect:./list";
	}
	
	@GetMapping("update")
	public String setUpdate(BoardVO boardVO, Model model)throws Exception{
		model.addAttribute("ar", qnaService.getSelect(boardVO));
		model.addAttribute("sp", "update");
		return "board/form";
	}
	
	@PostMapping("update")
	public String setUpdate(BoardVO boardVO)throws Exception{
		qnaService.setUpdate(boardVO);
		return "redirect:./list";
	}
	
	@GetMapping("reply")
	public String setReply(BoardVO boardVO, Model model)throws Exception{
		model.addAttribute("ar", new BoardVO(boardVO.getNum()));
		model.addAttribute("sp", "reply");
		return "board/form";
	}
	
	@PostMapping("reply")
	public String setReply(BoardVO boardVO, MultipartFile[] files)throws Exception{
		qnaService.setReply(boardVO, files);
		return "redirect:./list";
	}
}
