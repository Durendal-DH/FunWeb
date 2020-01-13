package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.dao.ArticleDAO;
import com.itwillbs.domain.ArticleBean;
import com.itwillbs.domain.BoardBean;
import com.itwillbs.domain.PageBean;

@Service
public class ArticleServiceImpl implements ArticleService{

	@Inject
	ArticleDAO articleDAO;
	
	@Override
	public List<BoardBean> getList(PageBean pageBean) {
		pageBean.setCurrentPage(Integer.parseInt(pageBean.getPageNum()));
		
		pageBean.setStartRow((pageBean.getCurrentPage()-1)*pageBean.getPageSize());
		
		return articleDAO.getList(pageBean);
	}

	@Override
	public List<ArticleBean> getArticleList(int num) {
		return articleDAO.getArticleList(num);
	}

	@Override
	public void insertArticle(BoardBean bb, List<ArticleBean> aList) {
		articleDAO.insertBoard(bb);
		int num = articleDAO.getBoardMaxNum();
		System.out.println(num);
		articleDAO.insertArticle(num,aList);
		
	}

	
}
