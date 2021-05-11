package com.iu.s1.board;

import java.util.List;

public interface BoardMapper {

	//List
	public List<BoardVO> getList()throws Exception;
	//Count
	public Long getTotalCount()throws Exception;
	//Select
	public BoardVO getSelect()throws Exception;
	//Insert
	public Long setBoard(BoardVO boardVO)throws Exception;
	//Update
	public Integer setUpdate(BoardVO boardVO)throws Exception;
	//HitUpdate
	public Integer setHitUpdate(BoardVO boardVO)throws Exception;
	//Delete
	public Integer setDelete(BoardVO boardVO)throws Exception;
}
