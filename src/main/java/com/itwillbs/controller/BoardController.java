package com.itwillbs.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.itwillbs.crawler.Crawler;
import com.itwillbs.domain.BoardBean;
import com.itwillbs.domain.CrawlerBean;
import com.itwillbs.domain.JournalBean;
import com.itwillbs.domain.MemberBean;
import com.itwillbs.domain.PageBean;
import com.itwillbs.service.BoardService;
import com.itwillbs.service.MemberService;

@Controller
public class BoardController {
	@Inject
	BoardService boardService;

	@Resource(name = "uploadPath")
	private String uploadPath;

	// http://localhost:8080/myweb2/board/fwrite
	@RequestMapping(value = "/board/fwrite", method = RequestMethod.GET)
	public String fwrite() {
		return "/center/fwriteForm";
	}

	// http://localhost:8080/myweb2/board/fwrite
	@RequestMapping(value = "/board/fwrite", method = RequestMethod.POST)
	public String fwritePost(MultipartFile file, HttpServletRequest request) throws Exception {
		System.out.println("/board/fwrite fwritePost()");
		System.out.println("originalName: " + file.getOriginalFilename());
		System.out.println("size: " + file.getSize());
		System.out.println("contentType: " + file.getContentType());

		// 실제 파일은 file.getBytes()
		// 파일 이름 동일 할경우 변경
		UUID uid = UUID.randomUUID();
		String saveName = uid.toString() + "_" + file.getOriginalFilename();
		System.out.println(saveName);
		// 파일을 upload 폴더에 넣기 => 파일 카피
		File target = new File(uploadPath, saveName);
		FileCopyUtils.copy(file.getBytes(), target);

		BoardBean bb = new BoardBean();
		bb.setName(request.getParameter("name"));
		bb.setPass(request.getParameter("pass"));
		bb.setSubject(request.getParameter("subject"));
		bb.setContent(request.getParameter("content"));
		bb.setFile(saveName);
		// BoardService 부모인터페이스 boardService =new BoardServiceImpl()
		// insertBoard(bb) 메서드호출
		boardService.insertBoard(bb);
		// /board/list
		return "redirect:/board/list";
	}

	// http://localhost:8080/myweb2/board/write
	@RequestMapping(value = "/board/write", method = RequestMethod.GET)
	public String write() {
		return "/center/writeForm";
	}

	// http://localhost:8080/myweb2/board/write
	@RequestMapping(value = "/board/write", method = RequestMethod.POST)
	public String writePost(BoardBean bb) {
		System.out.println("/board/write writePost()");
		// BoardService 부모인터페이스 boardService =new BoardServiceImpl()
		// insertBoard(bb) 메서드호출
		boardService.insertBoard(bb);
		// /board/list
		return "redirect:/board/list";
	}

	// http://localhost:8080/myweb2/board/list
	// http://localhost:8080/myweb2/board/list?pageNum=3
	@RequestMapping(value = "/board/list", method = RequestMethod.GET)
	public String list(PageBean pb, HttpServletRequest request, Model model) {
		// 한화면에 보여줄 글 개수
		pb.setPageSize(15);
		// // 현페이지 가져오기
		String pageNum = request.getParameter("pageNum");
		pb.setPageNum(pageNum);
		// // pageNum 없으면 pageNum="1" 설정
		if (pageNum == null) {
			pb.setPageNum("1");
		}
		// 디비에 1페이지 10개 글 가져오기
		List<BoardBean> boardList = boardService.getBoardList(pb);

		// 전체 글 개수 가져오기
		int count = boardService.getBoardCount();
		pb.setCount(count);

//			 System.out.println(pb.getPageCount());
//			 System.out.println(pb.getPageBlock());
//			 System.out.println(pb.getStartPage());
//			 System.out.println(pb.getEndPage());

		// 전체페이지 개수 계산하기
		// 한화면에 보여줄 페이지 개수
		// 시작페이지 번호 구하기
		// 끝페이지 번호 구하기

		model.addAttribute("boardList", boardList);
		model.addAttribute("pb", pb);

		return "/center/notice";
	}

	// http://localhost:8080/CrawlingWeb/board/crawler
	@RequestMapping(value = "/board/crawler", method = RequestMethod.GET)
	public String crawler() {
		return "/center/crawler";
	}

	// http://localhost:8080/CrawlingWeb/board/crawler
	@RequestMapping(value = "/board/crawler", method = RequestMethod.POST)
	public String crawler(CrawlerBean cb, HttpServletRequest request) {
		String path = request.getRealPath("");
		Crawler crawler = new Crawler();
		crawler.crawling(cb, path);
		return "redirect:/board/list";
	}

}
