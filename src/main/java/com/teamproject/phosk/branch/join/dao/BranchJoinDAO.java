package com.teamproject.phosk.branch.join.dao;

import com.teamproject.phosk.branch.login.vo.BranchLoginVO;

public interface BranchJoinDAO {
	public BranchLoginVO branchCheckIDForEmail(BranchLoginVO bvo);

	public int branchOnerRegister(BranchLoginVO bvo);
}
