package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.BoardBean;
import com.itwillbs.domain.PageBean;

public interface BoardService {
	//글쓰기
	public void insertBoard(BoardBean bb);
	//글목록
	public List<BoardBean> getBoardList(PageBean pb);
	public int getBoardCount();
}
