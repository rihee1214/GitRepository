package com.iu.s1.board.notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

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
	public String setInsert(NoticeVO noticeVO, MultipartFile[] files)throws Exception{
		noticeService.setBoard(noticeVO, files);
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
	public String setUpdate(NoticeVO noticeVO, MultipartFile[] files)throws Exception{
		noticeService.setUpdate(noticeVO);
		return "redirect:./list";
	}
	
	// /notice/fileDown이라는 주소로 들어오게 된다.
	//문제는 이게 template안에 들어가는것이 아니라, custom view로 넘어가게 해주어야한다.
	//fileDown
	@GetMapping("fileDown")
	public ModelAndView fileDown(String fileName, String oriName)throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.addObject("fileName", fileName);
		mv.addObject("oriName", oriName);
		mv.addObject("filePath", "/upload/notice/");
		
		//view의 이름은 bean의 이름과 일치시켜주어야 한다.
		//component에 아무것도 적혀져 있는 것이 없기 때문에 fileDown으로 자동 생성된다.
		//component옆에 적어주어야 해당 이름으로 찾아서 보내줄 수 있다.
		mv.setViewName("fileDown");
		return mv;
	}
}
