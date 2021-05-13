package com.iu.s1.board.qna;

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
public class QnaService implements BoardService{

	@Autowired
	private QnaMapper qnaMapper;
	@Autowired
	private FileManager fileManager;
	
	@Override
	public List<BoardVO> getList(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return qnaMapper.getList(pager);
	}

	@Override
	public BoardVO getSelect(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return qnaMapper.getSelect(boardVO);
	}

	@Override
	public Long getTotalCount(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return qnaMapper.getTotalCount(pager);
	}

	@Override
	public Long setBoard(BoardVO boardVO, MultipartFile[] files) throws Exception {
		// TODO Auto-generated method stub
		Long result = qnaMapper.setBoard(boardVO);
		
		String filePath="upload/qna/";
		for(MultipartFile file : files) {
			if(file.getSize()!=0) {
				BoardFileVO boardFileVO = new BoardFileVO();
				boardFileVO.setNum(boardVO.getNum());
				boardFileVO.setOriName(file.getOriginalFilename());
				boardFileVO.setFileName(fileManager.save(file, filePath));
				qnaMapper.setFileInsert(boardFileVO);
			}
		}
		
		return result;
	}

	@Override
	public Long setUpdate(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return qnaMapper.setUpdate(boardVO);
	}

	@Override
	public Long setHitUpdate(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return qnaMapper.setHitUpdate(boardVO);
	}

	@Override
	public Long setDelete(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return qnaMapper.setDelete(boardVO);
	}

}
