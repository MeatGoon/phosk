package com.teamproject.phosk.user.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.teamproject.phosk.user.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO{

	@Autowired
	private SqlSession session;

	@Override
	public void insertMember(MemberVO membervo) {
		
		session.insert("insertMember",membervo);
	}

	@Override
	public MemberVO login(MemberVO membervo) {
		
		return session.selectOne("login",membervo);
	}

	@Override
	public List<MemberVO> register() {
		
		return session.selectList("register");
	}
	@Override
	public void updatemember(MemberVO membervo) {
		session.update("updatemember", membervo);
		
	}
	@Override
	public MemberVO idchk(String member_id) {
		
		return  session.selectOne("idchk",member_id);
	
	}
	@Override
	public MemberVO nicchk(String member_nic) {
		
		return  session.selectOne("nicchk",member_nic);
	
	}

}
