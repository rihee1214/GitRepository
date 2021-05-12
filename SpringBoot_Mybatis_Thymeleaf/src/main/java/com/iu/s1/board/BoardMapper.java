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
	public Integer setUpdate(BoardVO boardVO)throws Exception;
	//HitUpdate
	public Integer setHitUpdate(BoardVO boardVO)throws Exception;
	//Delete
	public Integer setDelete(BoardVO boardVO)throws Exception;
}
