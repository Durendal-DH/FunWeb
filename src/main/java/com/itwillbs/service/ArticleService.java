package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.ArticleBean;
import com.itwillbs.domain.BoardBean;
import com.itwillbs.domain.PageBean;

public interface ArticleService {

	public List<BoardBean> getList(PageBean pageBean);

	public List<ArticleBean> getArticleList(int num);

}
