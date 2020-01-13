package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.ArticleBean;
import com.itwillbs.domain.BoardBean;
import com.itwillbs.domain.PageBean;
import com.itwillbs.domain.SearchBean;

public interface ArticleService {

	public int getListCount();

	public List<BoardBean> getList(SearchBean searchBean);

	public int getArticleListCount(int num);

	public List<ArticleBean> getArticleList(SearchBean searchBean);

	public void insertArticle(BoardBean bb, List<ArticleBean> aList);

	public List<ArticleBean> getArticleList(int board_num);

}
