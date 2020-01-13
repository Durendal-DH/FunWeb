package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.dao.ArticleDAO;
import com.itwillbs.domain.ArticleBean;
import com.itwillbs.domain.BoardBean;
import com.itwillbs.domain.PageBean;
import com.itwillbs.domain.SearchBean;

@Service
public class ArticleServiceImpl implements ArticleService{

	@Inject
	ArticleDAO articleDAO;
	
	public int getListCount() {
		// TODO Auto-generated method stub
		return articleDAO.getListCount();
	}
	
	@Override
	public List<BoardBean> getList(SearchBean searchBean) {
		return articleDAO.getList(searchBean);
	}

	@Override
	public int getArticleListCount(int num) {
		// TODO Auto-generated method stub
		return articleDAO.getArticleListCount(num);
	}

	@Override
	public List<ArticleBean> getArticleList(SearchBean searchBean) {
		return articleDAO.getArticleList(searchBean);
	}

	@Override
	public void insertArticle(BoardBean bb, List<ArticleBean> aList) {
		articleDAO.insertBoard(bb);
		int num = articleDAO.getBoardMaxNum();
		System.out.println(num);
		articleDAO.insertArticle(num,aList);
		
	}

	@Override
	public List<ArticleBean> getArticleList(int board_num) {
		return articleDAO.getArticleList(board_num);
	}

	
}
