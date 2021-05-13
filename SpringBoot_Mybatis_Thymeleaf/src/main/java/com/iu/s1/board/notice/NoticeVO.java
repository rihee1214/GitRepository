package com.iu.s1.board.notice;

import java.util.List;

import com.iu.s1.board.BoardFileVO;
import com.iu.s1.board.BoardVO;

import lombok.Data;

@Data
public class NoticeVO extends BoardVO{

	private List<BoardFileVO> boardFileVOs;
}
