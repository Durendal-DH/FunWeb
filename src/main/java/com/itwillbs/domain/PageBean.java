package com.itwillbs.domain;

public class PageBean {

	private int count;
	private int pageSize;
	private String pageNum;
	private int currentPage;
	private int startRow;
	private int endRow;
	
	private int pageCount;
	private int pageBlock;
	private int startPage;
	private int endPage;
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
		pageinit();
	}
	public void pageinit() {
			//  전체페이지 개수 계산하기  
		pageCount=count/pageSize + (count%pageSize==0?0:1);
				//  한화면에 보여줄 페이지 개수
		pageBlock=10;
		//  시작페이지 번호 구하기
		startPage=((currentPage-1)/pageBlock)*pageBlock+1;
		endPage=startPage+pageBlock-1;
		if(endPage > pageCount){
			 endPage=pageCount;
		 }
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getPageNum() {
		return pageNum;
	}
	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getEndRow() {
		return endRow;
	}
	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getPageBlock() {
		return pageBlock;
	}
	public void setPageBlock(int pageBlock) {
		this.pageBlock = pageBlock;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	
	
}
