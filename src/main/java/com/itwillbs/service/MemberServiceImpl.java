package com.itwillbs.service;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.dao.MemberDAO;
import com.itwillbs.domain.MemberBean;

@Service
public class MemberServiceImpl implements MemberService{
	@Inject
	MemberDAO memberDAO;
	
	@Override
	public void insertMember(MemberBean mb) {
		System.out.println("MemberServiceImpl insertMember()");
		// 가입날짜 처리
		mb.setReg_date(new Timestamp(System.currentTimeMillis()));
		// MemberDAO 부모인터페이스 memberDAO = new MemberDAOImpl
		// insertMember(mb) 메서드호출
		memberDAO.insertMember(mb);
	}

	@Override
	public MemberBean userCheck(MemberBean mb) {
		return memberDAO.userCheck(mb);
	}

	@Override
	public MemberBean getMember(String id) {
		return memberDAO.getMember(id);
	}

	@Override
	public void updateMember(MemberBean mb) {
		memberDAO.updateMember(mb);
	}

	@Override
	public void deleteMember(MemberBean mb) {
		memberDAO.deleteMember(mb);
		
	}

	@Override
	public List<MemberBean> getMemberList() {
		
		return memberDAO.getMemberList();
	}

}
