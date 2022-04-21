package com.teamproject.phosk.user.main.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.teamproject.phosk.branch.info.vo.BranchInfoVO;

@Repository
public class UsermainDAOImpl implements UsermainDAO{
	@Autowired
	private SqlSession session;
	
	@Override
	public List<BranchInfoVO> branchlist(){
		
		return session.selectList("branchlist");
	}
}
