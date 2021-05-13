package com.iu.s1.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.s1.board.BoardFileVO;
import com.iu.s1.board.BoardService;
import com.iu.s1.board.BoardVO;
import com.iu.s1.util.FileManager;
import com.iu.s1.util.Pager;

@Service
public class NoticeService implements BoardService{

	@Autowired
	private NoticeMapper noticeMapper;
	@Autowired
	private FileManager fileManager;
	
	@Override
	public List<BoardVO> getList(Pager pager) throws Exception {
		return noticeMapper.getList(pager);
	}

	@Override
	public Long getTotalCount(Pager pager) throws Exception {
		return noticeMapper.getTotalCount(pager);
	}


	@Override
	public Long setBoard(BoardVO boardVO, MultipartFile[] files) throws Exception {
		String filePath = "upload/notice/";
		Long result = noticeMapper.setBoard(boardVO);
		for(MultipartFile file : files) {
			if(file.getSize()!=0) {
				BoardFileVO boardFileVO = new BoardFileVO();
				boardFileVO.setNum(boardVO.getNum());
				boardFileVO.setFileName(fileManager.save(file, filePath));
				boardFileVO.setOriName(file.getOriginalFilename());
				noticeMapper.setFileInsert(boardFileVO);
			}
		}
		return result;
	}

	@Override
	public Long setUpdate(BoardVO boardVO) throws Exception {
		return noticeMapper.setUpdate(boardVO);
	}

	@Override
	public Long setHitUpdate(BoardVO boardVO) throws Exception {
		return noticeMapper.setHitUpdate(boardVO);
	}

	@Override
	public Long setDelete(BoardVO boardVO) throws Exception {
		return noticeMapper.setDelete(boardVO);
	}

	@Override
	public BoardVO getSelect(BoardVO boardVO) throws Exception {
		return noticeMapper.getSelect(boardVO);
	}

	
}
