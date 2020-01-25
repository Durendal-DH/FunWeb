package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.ArticleBean;
import com.itwillbs.domain.BoardBean;
import com.itwillbs.domain.CrawlerBean;
import com.itwillbs.domain.PageBean;
import com.itwillbs.domain.SearchBean;

public interface ArticleService {
	
	public BoardBean getBoardNum(CrawlerBean crawlerBean);
	
	public List<String> getPopularKeyword();

	public int getListCount(SearchBean searchBean);

	public List<BoardBean> getList(SearchBean searchBean);

	public int getArticleListCount(int num);

	public List<ArticleBean> getArticleList(SearchBean searchBean);
	
	public List<ArticleBean> getArticleList(int num);

	public void insertArticle(BoardBean bb, List<ArticleBean> aList);

	public int checkData(CrawlerBean cb);

	public void deleteboard_Article(int check);

	public void updateCount(int num);
	
}
