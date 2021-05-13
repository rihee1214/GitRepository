package com.iu.s1.board.qna;

import java.util.List;

import com.iu.s1.board.BoardFileVO;
import com.iu.s1.board.BoardVO;

import lombok.Data;

@Data
public class QnaVO extends BoardVO{

	private Long ref;
	private Long step;
	private Long depth;
	private List<BoardFileVO> boardFileVOs;
}
