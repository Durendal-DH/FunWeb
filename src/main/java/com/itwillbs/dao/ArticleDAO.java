package com.itwillbs.dao;

import java.util.List;

import com.itwillbs.domain.ArticleBean;
import com.itwillbs.domain.BoardBean;
import com.itwillbs.domain.CrawlerBean;
import com.itwillbs.domain.PageBean;
import com.itwillbs.domain.SearchBean;

public interface ArticleDAO {

	public int getListCount();

	public List<BoardBean> getList(SearchBean searchBean);

	public int getArticleListCount(int num);

	public List<ArticleBean> getArticleList(SearchBean searchBean);

	public List<ArticleBean> getArticleList(int num);
	
	public void updateCount(int num);
	
	public void insertBoard(BoardBean bb);

	public int getBoardMaxNum();

	public void insertArticle(int num, List<ArticleBean> aList);

	public int checkData(CrawlerBean cb);

	public void deleteboard_Article(int num);


}
