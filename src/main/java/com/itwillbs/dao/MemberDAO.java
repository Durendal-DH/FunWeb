package com.itwillbs.dao;

import java.util.List;

import com.itwillbs.domain.MemberBean;

public interface MemberDAO {
	    //회원가입 추상메서드
		public void insertMember(MemberBean mb);
		// 로그인
		public MemberBean userCheck(MemberBean mb);
		// 회원정보조회
		public MemberBean getMember(String id);
		// 회원정보수정
		public void updateMember(MemberBean mb);
		// 회원정보삭제
				public void deleteMember(MemberBean mb);
				//회원목록
				public List<MemberBean> getMemberList();
}
