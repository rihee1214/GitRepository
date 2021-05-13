package com.iu.s1.board;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.iu.s1.util.Pager;

public interface BoardService {

		//List
		public List<BoardVO> getList(Pager pager)throws Exception;
		//Select
		public BoardVO getSelect(BoardVO boardVO)throws Exception;
		//TotalCount
		public Long getTotalCount(Pager pager)throws Exception;
		//Insert
		public Long setBoard(BoardVO boardVO, MultipartFile[] files)throws Exception;
		//Update
		public Long setUpdate(BoardVO boardVO)throws Exception;
		//HitUpdate
		public Long setHitUpdate(BoardVO boardVO)throws Exception;
		//Delete
		public Long setDelete(BoardVO boardVO)throws Exception;
}
