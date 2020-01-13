package com.itwillbs.dao;

import java.util.List;

import com.itwillbs.domain.ArticleBean;
import com.itwillbs.domain.BoardBean;
import com.itwillbs.domain.PageBean;

public interface ArticleDAO {

	public List<BoardBean> getList(PageBean pageBean);

	public List<ArticleBean> getArticleList(int num);

}
