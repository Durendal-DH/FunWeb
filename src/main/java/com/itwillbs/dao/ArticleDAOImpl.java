package com.itwillbs.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.ArticleBean;
import com.itwillbs.domain.BoardBean;
import com.itwillbs.domain.PageBean;

@Repository
public class ArticleDAOImpl implements ArticleDAO {
	
	@Inject
	SqlSession sqlSession;
	
	private static final String namespace="com.itwillbs.mapper.ArticleMapper";

	@Override
	public List<BoardBean> getList(PageBean pageBean) {
		return sqlSession.selectList(namespace+".getList",pageBean);
	}

	@Override
	public List<ArticleBean> getArticleList(int num) {
		return sqlSession.selectList(namespace+".getArticleList", num);
	}

	@Override
	public void insertBoard(BoardBean bb) {
		sqlSession.insert(namespace+".insertBoard",bb);		
	}

	@Override
	public int getBoardMaxNum() {
		return sqlSession.selectOne(namespace+".getBoardMaxNum");
	}

	@Override
	public void insertArticle(int num, List<ArticleBean> aList) {
		for(ArticleBean ab : aList) {
			ab.setBoard_num(num);
			sqlSession.insert(namespace+".insertArticle",ab);
		}
		
	}
	
	

}
