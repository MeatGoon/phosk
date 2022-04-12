package com.teamproject.phosk.user.dao;

import java.util.List;

import com.teamproject.phosk.user.vo.MemberVO;

public interface MemberDAO {

	void insertMember(MemberVO membervo);
	
	public MemberVO login(MemberVO membervo);

	List<MemberVO> register();
	
	public void updatemember(MemberVO membervo);
	
	public MemberVO idchk(String member_id);
	
	public MemberVO nicchk(String member_nic);

}
