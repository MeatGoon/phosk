package com.teamproject.phosk.user.service;

import java.util.List;

import com.teamproject.phosk.user.vo.MemberVO;

public interface MemberService {
	public void insertMember(MemberVO membervo);
	
	public MemberVO login(MemberVO membervo);
	
	List<MemberVO> register();

	public void updatemember(MemberVO membervo);
	
	public int idchk(MemberVO membervo);
}
