package com.iu.s1.board.qna;

import java.util.List;

import com.iu.s1.board.BoardFileVO;
import com.iu.s1.board.BoardVO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class QnaVO extends BoardVO{

	private Long ref;
	private Long step;
	private Long depth;
	
	private List<BoardFileVO> boardFileVOs;
	
	public QnaVO(Long num) {
		this.setNum(num);
	}
}
