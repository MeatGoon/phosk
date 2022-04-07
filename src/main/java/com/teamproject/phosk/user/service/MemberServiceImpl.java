package com.teamproject.phosk.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamproject.phosk.user.dao.MemberDAO;
import com.teamproject.phosk.user.vo.MemberVO;
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
		
		System.out.println(membervo.getMember_nic());
		System.out.println(membervo.getMember_pwd());
	}
		
}
