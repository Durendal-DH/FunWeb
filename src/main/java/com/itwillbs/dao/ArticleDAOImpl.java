package com.itwillbs.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.ArticleBean;
import com.itwillbs.domain.BoardBean;
import com.itwillbs.domain.CrawlerBean;
import com.itwillbs.domain.PageBean;
import com.itwillbs.domain.SearchBean;

@Repository
public class ArticleDAOImpl implements ArticleDAO {
	
	@Inject
	SqlSession sqlSession;
	
	private static final String namespace="com.itwillbs.mapper.ArticleMapper";

	
	@Override
	public List<String> getPopularKeyword() {
		return sqlSession.selectList(namespace+".getPopularKeyword");
	}

	@Override
	public int getListCount() {
		return sqlSession.selectOne(namespace+".getListCount");
	}
	
	@Override
	public List<BoardBean> getList(SearchBean searchBean) {
		return sqlSession.selectList(namespace+".getList", searchBean);
	}
	
	@Override
	public int getArticleListCount(int num) {
		return sqlSession.selectOne(namespace+".getArticleListCount", num);
	}

	@Override
	public List<ArticleBean> getArticleList(SearchBean searchBean) {
		return sqlSession.selectList(namespace+".getArticleList", searchBean);
	}

	
	@Override
	public void updateCount(int num) {
		int count = sqlSession.selectOne(namespace+".selectCount",num);
		BoardBean boardBean = new BoardBean();
		boardBean.setCount(count+1);
		boardBean.setNum(num);
		sqlSession.update(namespace+".updateCount", boardBean);
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

	@Override
	public int checkData(CrawlerBean cb) {

		BoardBean bb = null;
		bb = sqlSession.selectOne(namespace+".checkDate_keyword",cb);
		if(bb == null) {
			return 0; // 
		}else {
			if(bb.getPage()>=cb.getPage()) {
				return -1; // history back
			}else {
				return bb.getNum();
			}
		}
		
	
	}

	@Override
	public void deleteboard_Article(int num) {
		sqlSession.delete(namespace+".deleteBoard",num);
		sqlSession.delete(namespace+".deleteArticle",num);
	}

	@Override
	public List<ArticleBean> getArticleList(int board_num) {
		return sqlSession.selectList(namespace+".getArticleListE", board_num);
	}
	
	

}
