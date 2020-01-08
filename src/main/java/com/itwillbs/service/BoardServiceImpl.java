package com.itwillbs.service;

import java.sql.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.dao.BoardDAO;
import com.itwillbs.domain.BoardBean;
import com.itwillbs.domain.PageBean;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Inject
	BoardDAO boardDAO;
	
	@Override
	public void insertBoard(BoardBean bb) {
		//num 구하기
		bb.setNum(boardDAO.getMaxNum()+1);
		//조회수 0
		bb.setReadcount(0);
		// ref num같이 
		bb.setRe_ref(boardDAO.getMaxNum()+1);
		// seq  lev  0
		bb.setRe_lev(0);
		bb.setRe_seq(0);
		// 날짜
		bb.setDate(new Date(System.currentTimeMillis()));
		boardDAO.insertBoard(bb);
	}

	@Override
	public List<BoardBean> getBoardList(PageBean pb) {
		// pageNum , pageSize
		// startRow 구하는 작업
		// int startRow = (currentPage-1)*pageSize+1;
		
		//  pstmt.setInt(1, startRow-1);
		
		// (currentPage-1)*pageSize
		pb.setCurrentPage(Integer.parseInt(pb.getPageNum()));
		
		pb.setStartRow((pb.getCurrentPage()-1)*pb.getPageSize());
		
		return boardDAO.getBoardList(pb);
	}

	@Override
	public int getBoardCount() {
		return boardDAO.getBoardCount();
	}

}
