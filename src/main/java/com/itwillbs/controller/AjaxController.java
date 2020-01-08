package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itwillbs.domain.BoardBean;
import com.itwillbs.domain.MemberBean;
import com.itwillbs.domain.PageBean;
import com.itwillbs.service.BoardService;
import com.itwillbs.service.MemberService;

@RestController
public class AjaxController {
	@Inject
	BoardService boardService;
	@Inject
	MemberService memberService;
	
	// http://localhost:8080/myweb2/member/idcheck
			@RequestMapping(value = "/member/idcheck", method = RequestMethod.GET)
			public ResponseEntity<String> idcheck(HttpServletRequest request) {
				ResponseEntity<String> entity=null;
				String result="";
				try {
					String id=request.getParameter("id");
					
					MemberBean mb=memberService.getMember(id);
					if(mb!=null) {
						System.out.println("아이디중복");
						result="iddup";
					}else {
						System.out.println("아이디사용가능");
						result="idok";
					}
					entity=new ResponseEntity<String>(result,HttpStatus.OK);
				} catch (Exception e) {
					e.printStackTrace();
					entity=new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
				}
				return entity;
			}
			
			//http://localhost:8080/FunWeb/member/main
			// http://localhost:8080/myweb2/board/list2
			@RequestMapping(value = "/board/list2", method = RequestMethod.GET)
			public ResponseEntity<List<BoardBean>> list2(HttpServletRequest request) {
					ResponseEntity<List<BoardBean>> entity=null;
					try {
						PageBean pb=new PageBean();
						pb.setPageNum("1");
						pb.setPageSize(5);
				
		entity=new ResponseEntity<List<BoardBean>>(boardService.getBoardList(pb),HttpStatus.OK);
					} catch (Exception e) {
						e.printStackTrace();
						entity=new ResponseEntity<List<BoardBean>>(HttpStatus.BAD_REQUEST);
					}
						return entity;
				}
	

}
