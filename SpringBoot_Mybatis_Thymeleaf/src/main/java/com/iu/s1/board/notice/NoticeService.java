package com.iu.s1.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.s1.board.BoardService;
import com.iu.s1.board.BoardVO;

@Service
public class NoticeService implements BoardService{

	@Autowired
	private NoticeMapper noticeMapper;
	
	@Override
	public List<BoardVO> getList() throws Exception {
		return noticeMapper.getList();
	}

	@Override
	public Long getTotalCount() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Long setBoard(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer setUpdate(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer setHitUpdate(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer setDelete(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardVO getSelect(BoardVO boardVO) throws Exception {
		return noticeMapper.getSelect(boardVO);
	}

	
}
