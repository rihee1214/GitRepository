package com.iu.s1.board;

import java.util.List;

import com.iu.s1.util.Pager;

public interface BoardMapper {

	//List
	public List<BoardVO> getList(Pager pager)throws Exception;
	//Count
	public Long getTotalCount(Pager pager)throws Exception;
	//Select
	public BoardVO getSelect(BoardVO boardVO)throws Exception;
	//Insert
	public Long setBoard(BoardVO boardVO)throws Exception;
	//Update
	public Long setUpdate(BoardVO boardVO)throws Exception;
	//HitUpdate
	public Long setHitUpdate(BoardVO boardVO)throws Exception;
	//Delete
	public Long setDelete(BoardVO boardVO)throws Exception;
	//FileInsert
	public Long setFileInsert(BoardFileVO boardFileVO)throws Exception;
}
