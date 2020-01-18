package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.dao.ArticleDAO;
import com.itwillbs.domain.ArticleBean;
import com.itwillbs.domain.BoardBean;
import com.itwillbs.domain.CrawlerBean;
import com.itwillbs.domain.PageBean;
import com.itwillbs.domain.SearchBean;

@Service
public class ArticleServiceImpl implements ArticleService{

	@Inject
	ArticleDAO articleDAO;
	
	@Override
	public List<String> getPopularKeyword() {
		return articleDAO.getPopularKeyword();
	}

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
	public List<ArticleBean> getArticleList(int num) {
		return articleDAO.getArticleList(num);
	}
	
	
	@Override
	public void updateCount(int num) {
		System.out.println("updateCount");
		articleDAO.updateCount(num);
	}

	@Override
	public void insertArticle(BoardBean bb, List<ArticleBean> aList) {
		articleDAO.insertBoard(bb);
		int num = articleDAO.getBoardMaxNum();
		articleDAO.insertArticle(num,aList);
		
	}

	@Override
	public int checkData(CrawlerBean cb) {
		return articleDAO.checkData(cb);
	}

	@Override
	public void deleteboard_Article(int check) {
		articleDAO.deleteboard_Article(check);		
	}

	
}
