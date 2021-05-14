package com.iu.s1.board.notice;

import java.util.List;

import com.iu.s1.board.BoardFileVO;
import com.iu.s1.board.BoardVO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NoticeVO extends BoardVO{

	private List<BoardFileVO> boardFileVOs;
}
