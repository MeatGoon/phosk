package com.teamproject.phosk.user.main.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.teamproject.phosk.branch.info.vo.BranchInfoVO;
import com.teamproject.phosk.branch.qr.vo.BranchQRVO;
import com.teamproject.phosk.user.main.paging.Criteria;

@Repository
public class UsermainDAOImpl implements UsermainDAO{
	@Autowired
	private SqlSession session;
	
	@Override
	public List<BranchInfoVO> branchlist(){
		
		return session.selectList("branchlist");
	}
	//가게 목록 + 페이징
	@Override
	public List<BranchInfoVO> branchpaging(Criteria cri){
		return session.selectList("branchpaging",cri);
	}
	//가게 총 개수
	@Override
	public int listcount() {
		return session.selectOne("listcount");
	}
	//qr테이블
	@Override
	public List<BranchQRVO> qrlist(){
		return session.selectList("qrlist");
	}
}
