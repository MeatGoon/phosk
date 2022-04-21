package com.teamproject.phosk.branch.join.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamproject.phosk.branch.join.dao.BranchJoinDAO;
import com.teamproject.phosk.branch.login.vo.BranchLoginVO;

import lombok.ToString;
import lombok.extern.log4j.Log4j;


@Log4j
@Service
@ToString
public class BranchJoinServiceImpl implements BranchJoinService {
	
	@Autowired
	private BranchJoinDAO dao;
	
	@Override
	public BranchLoginVO branchCheckIDForEmail(BranchLoginVO bvo) {
		System.out.println(bvo + "!!!!!");
		return dao.branchCheckIDForEmail(bvo);
	}

	@Override
	public boolean branchOnerRegister(BranchLoginVO bvo) {
		return dao.branchOnerRegister(bvo) == 1;
	}

}
