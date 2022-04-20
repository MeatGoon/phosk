package com.teamproject.phosk.user.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamproject.phosk.branch.info.vo.BranchInfoVO;
import com.teamproject.phosk.user.main.dao.UsermainDAO;

@Service
public class UsermainServiceImpl implements UsermainService{
	
	@Autowired
	private UsermainDAO usermaindao;
	
	@Override
	public List<BranchInfoVO> branchlist(){
		return usermaindao.branchlist();
	}

}
