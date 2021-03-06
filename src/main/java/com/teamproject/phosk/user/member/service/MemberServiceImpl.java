package com.teamproject.phosk.user.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamproject.phosk.user.member.dao.MemberDAO;
import com.teamproject.phosk.user.member.vo.MemberVO;
@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDAO memberdao;
	
	@Override
	public void insertMember(MemberVO membervo) {
		memberdao.insertMember(membervo);
		
	}

	@Override
	public MemberVO login(MemberVO membervo) {
		return memberdao.login(membervo);
		
	}

	@Override
	public List<MemberVO> register() {
		
		return memberdao.register();
	}

	@Override
	public void updatemember(MemberVO membervo) {
		memberdao.updatemember(membervo);		
	}
	@Override
	public void userdel(String member_id) {
		memberdao.userdel(member_id);
	}
	
	@Override
	public MemberVO idchk(String member_id) {
		return memberdao.idchk(member_id);
	}
	@Override
	public MemberVO nicchk(String member_nic) {
		return memberdao.nicchk(member_nic);
	}
		
}
