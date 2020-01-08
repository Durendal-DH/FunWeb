package com.itwillbs.dao;

import java.util.List;

import com.itwillbs.domain.BoardBean;
import com.itwillbs.domain.PageBean;

public interface BoardDAO {
	public void insertBoard(BoardBean bb);
	public int getMaxNum();
	
	//글목록
	public List<BoardBean> getBoardList(PageBean pb);
	public int getBoardCount();
		
}
