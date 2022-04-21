package com.teamproject.phosk.branch.join.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.teamproject.phosk.branch.login.vo.BranchLoginVO;
@Repository
public class BranchJoinDAOImpl implements BranchJoinDAO {

	@Autowired
	private SqlSession session;
	
	@Override
	public BranchLoginVO branchCheckIDForEmail(BranchLoginVO bvo) {
		return session.selectOne("branchCheckIDForEmail" , bvo);
	}

	@Override
	public int branchOnerRegister(BranchLoginVO bvo) {
		return session.insert("branchOnerRegister", bvo);
	}

}
