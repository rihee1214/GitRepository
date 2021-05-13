package com.iu.s1.board.qna;

import org.apache.ibatis.annotations.Mapper;

import com.iu.s1.board.BoardMapper;
import com.iu.s1.board.BoardVO;

@Mapper
public interface QnaMapper extends BoardMapper{

	public QnaVO getReplySelect(BoardVO boardVO)throws Exception;
	
	public Long setReply(QnaVO qnaVO)throws Exception;
	
	public Long setInsertUpdate(QnaVO qnaVO)throws Exception;
}
