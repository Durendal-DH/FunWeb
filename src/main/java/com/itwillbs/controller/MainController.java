package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpServerErrorException;

import com.itwillbs.crawler.Crawler;
import com.itwillbs.domain.ArticleBean;
import com.itwillbs.domain.BoardBean;
import com.itwillbs.domain.CrawlerBean;
import com.itwillbs.domain.PageBean;
import com.itwillbs.service.ArticleService;

@Controller
public class MainController {
	@Inject
	ArticleService articleService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "/index";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(PageBean pageBean, HttpServletRequest request, Model model) {
		
		pageBean.setPageSize(10);
		String pageNum = request.getParameter("pageNum");
		pageBean.setPageNum(pageNum);
		if(pageNum == null) {
			pageBean.setPageNum("1");
		}
		List<BoardBean> List = articleService.getList(pageBean);
		
		model.addAttribute("List",List);
		model.addAttribute("pageBean",pageBean);
		return "/list";
		
	}
	
	@RequestMapping(value = "/content", method = RequestMethod.GET)
	public String content(HttpServletRequest request, Model model) {
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		List<ArticleBean> ArticleList = articleService.getArticleList(num);
		model.addAttribute("ArticleList",ArticleList);
		model.addAttribute("pageNum",pageNum);
		return "/content";
	}
	
	@RequestMapping(value = "/crawler", method = RequestMethod.POST)
	public String crawler(CrawlerBean cb, HttpServletRequest request) {
		String path =  request.getRealPath("");
		System.out.println("/board/write writePost()");
		
		//cb로 db 조회해서 같은 keyword, 같은 날짜, 같거나 더큰 page 가 존재하는지 확인후 해당사항이 없을시 크롤링시작
		
		Crawler crawler = new Crawler();
		List<ArticleBean> aList = crawler.crawling(cb,path);
		BoardBean bb = new BoardBean();
		bb.setKeyword(cb.getKeyword());
		bb.setPage(cb.getPage());
		bb.setCount(0);
		articleService.insertArticle(bb,aList);
		
		
		// /board/list
		return "redirect:/list";
	}


}
