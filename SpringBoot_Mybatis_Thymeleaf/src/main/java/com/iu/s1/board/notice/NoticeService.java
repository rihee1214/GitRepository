package com.iu.s1.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
//		throw new ArithmeticException();
		return noticeMapper.getList(pager);
	}

	@Override
	public Long getTotalCount(Pager pager) throws Exception {
		return noticeMapper.getTotalCount(pager);
	}

	@Override
	@Transactional(rollbackFor = Exception.class) //Exception이 발생하면 rollback 클래스에 줘도 된다.
	public Long setBoard(BoardVO boardVO, MultipartFile[] files) throws Exception {
		String filePath = "upload/notice/";
		Long result = noticeMapper.setBoard(boardVO);
		if(result<=0) {
			//에러는 아니지만 원하는 방향은 아니기 때문에 강제로 예외 발생
			throw new Exception();
		}
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
