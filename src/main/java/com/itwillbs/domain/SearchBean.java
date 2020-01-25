package com.itwillbs.domain;

public class SearchBean {
	private int limit;
	private int startRow;
	private int num;
	private String keyword;
	private int page;
	
	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public SearchBean() {}
	
	public SearchBean(String keyword, int page) {
		this.keyword = keyword;
		this.page = page;
	}

	public SearchBean(int limit, int startRow, int num) {
		this.limit = limit;
		this.startRow = startRow;
		this.num = num;
	}
	
	public SearchBean(int limit, int startRow, String keyword, int page) {
		this.limit = limit;
		this.startRow = startRow;
		this.keyword = keyword;
		this.page = page;
	}
	
}
