package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.MemberBean;
import com.itwillbs.service.MemberService;

@Controller
public class MemberController {
	@Inject
	MemberService memberService;
	// http://localhost:8080/myweb2/member/insert  
	@RequestMapping(value = "/member/insert", method = RequestMethod.GET)
	public String insert() {
		return "/member/join";
	}
	// http://localhost:8080/myweb2/member/insert  
	@RequestMapping(value = "/member/insert", method = RequestMethod.POST)
	public String insertPost(MemberBean mb) {
		System.out.println("/member/insert insertPost()");
		// MemberService 부모인터페이스 memberService =new MemberServiceImpl()
		// insertMember(mb) 메서드호출
		memberService.insertMember(mb);
		// /member/login
		return "redirect:/member/login";
	}
	// http://localhost:8080/myweb2/member/login  
		@RequestMapping(value = "/member/login", method = RequestMethod.GET)
		public String login() {
			return "/member/login";
		}
		
		// http://localhost:8080/myweb2/member/login  
		@RequestMapping(value = "/member/login", method = RequestMethod.POST)
		public String loginPost(MemberBean mb,HttpSession session,Model model) {
			System.out.println("/member/login loginPost()");
			// MemberService 부모인터페이스 memberService =new MemberServiceImpl()
			// userCheck(mb) 메서드호출
			MemberBean mb2=memberService.userCheck(mb);
			if(mb2!=null) { 
				//일치  세션값 생성  이동  /member/main
				session.setAttribute("id", mb.getId());
				// /member/main
				return "redirect:/member/main";
			}else {
				// 틀림 "아이디비밀번호 일치 하지 않음" 뒤로이동
				// 일치하지 않으면  
				// 메시지 저장 
				model.addAttribute("msg","잘못 입력하신 데이터입니다");
				// 이동 msg.jsp "잘못 입력하신 데이터입니다"  //뒤로이동
				return "/member/msg";
			}
			
		}
		
		@RequestMapping(value = "/member/main", method = RequestMethod.GET)
		public String main() {
			return "/main/main";
		}
		
		@RequestMapping(value = "/member/logout", method = RequestMethod.GET)
		public String logout(HttpSession session) {
			session.invalidate();
			return "redirect:/member/main";
		}
		
		@RequestMapping(value = "/member/info", method = RequestMethod.GET)
		public String info(HttpSession session,Model model) {
			//세션값 가져오기
			String id=(String)session.getAttribute("id");
			// 디비에서 id해당하는 정보를 조회
			MemberBean mb=memberService.getMember(id);
			// mb를 model에 담아서 info.jsp 이동
			model.addAttribute("mb",mb);
			return "/member/info";
		}
		@RequestMapping(value = "/member/update", method = RequestMethod.GET)
		public String update(HttpSession session,Model model) {
			//세션값 가져오기
			String id=(String)session.getAttribute("id");
			// 디비에서 id해당하는 정보를 조회
			MemberBean mb=memberService.getMember(id);
			// mb를 model에 담아서 updateForm.jsp 이동
			model.addAttribute("mb",mb);
			return "/member/updateForm";
		}
		@RequestMapping(value = "/member/update", method = RequestMethod.POST)
		public String updatePost(MemberBean mb,Model model) {
			// userCheck(mb) 메서드호출 아이디 비밀번호 일치 체크
			MemberBean mb2=memberService.userCheck(mb);
			if(mb2!=null) {
				// 수정메서드 호출 updateMember(mb)
				memberService.updateMember(mb);
				// /member/main
				return "redirect:/member/main";
			}else {
				// 틀림 "아이디비밀번호 일치 하지 않음" 뒤로이동
				// 일치하지 않으면  
				// 메시지 저장 
				model.addAttribute("msg","잘못 입력하신 데이터입니다");
				// 이동 msg.jsp "잘못 입력하신 데이터입니다"  //뒤로이동
				return "/member/msg";
			}
		}
		
		@RequestMapping(value = "/member/delete", method = RequestMethod.GET)
		public String delete() {
			return "/member/deleteForm";
		}
		@RequestMapping(value = "/member/delete", method = RequestMethod.POST)
		public String deletePost(MemberBean mb,Model model,HttpSession session) {
			// userCheck(mb) 메서드호출 아이디 비밀번호 일치 체크
			MemberBean mb2=memberService.userCheck(mb);
			if(mb2!=null) {
				// 수정메서드 호출 deleteMember(mb)
				memberService.deleteMember(mb);
				// 세션값 초기화
				session.invalidate();
				// /member/main
				return "redirect:/member/main";
			}else {
				// 틀림 "아이디비밀번호 일치 하지 않음" 뒤로이동
				// 일치하지 않으면  
				// 메시지 저장 
				model.addAttribute("msg","잘못 입력하신 데이터입니다");
				// 이동 msg.jsp "잘못 입력하신 데이터입니다"  //뒤로이동
				return "/member/msg";
			}
		}
		
		@RequestMapping(value = "/member/list", method = RequestMethod.GET)
		public String list(HttpSession session,Model model) {
			//세션값 가져오기  제어
			String id=(String)session.getAttribute("id");
			// 디비에서 회원 모든 정보를 조회
			List<MemberBean> mbList=memberService.getMemberList();
			// mb를 model에 담아서 updateForm.jsp 이동
			model.addAttribute("mbList",mbList);
			return "/member/list";
		}
		
}
