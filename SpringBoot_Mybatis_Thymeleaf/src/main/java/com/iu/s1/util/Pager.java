package com.iu.s1.util;

import lombok.Data;

@Data
public class Pager {

	private Long curPage;
	private Long curBlock;
	
	private Long perPage;
	private Long perBlock;
	
	private Long startRow;
	
	private Long totalPage;
	private Long totalBlock;
	
	private Long startNum;
	private Long lastNum;
	
	private Boolean pre;
	private Boolean next;
	
	public void makeRow(Long totalcount) {
		this.perPage = (this.perPage == null || this.perPage <= 0) ? 10L : this.perPage;
		this.perBlock = (this.perBlock == null || this.perBlock <= 0) ? 5L : this.perBlock;
		
		this.kind = this.kind==null ? "" : this.kind;
		this.search = this.search==null ? "" : this.search;
		
		this.curPage = (this.curPage == null) ? 1L : this.curPage;
		this.startRow = (this.curPage-1)*this.perPage;
		
		this.totalPage = totalcount/this.perPage;
		this.totalPage += (totalcount%this.perPage==0) ? 0 : 1L;
		
		this.totalBlock = this.totalPage/this.perBlock;
		this.totalBlock += (this.totalPage%this.perBlock==0) ? 0 : 1L;
		
		this.curBlock = (this.curBlock==null||this.curBlock < 1) 
										? (this.curPage/this.perBlock + ((this.curPage%this.perBlock == 0) ? 0L : 1L))
										: this.curBlock;
		
		this.lastNum = this.curBlock*this.perBlock;
		this.startNum = this.lastNum-this.perBlock+1;
		
		this.lastNum = (this.curBlock==this.totalBlock) ? this.totalPage : this.lastNum;
		
		this.pre = this.curBlock > 1;
		this.next = this.curBlock < this.totalBlock;
	}
	
	private String kind;
	private String search;
}
