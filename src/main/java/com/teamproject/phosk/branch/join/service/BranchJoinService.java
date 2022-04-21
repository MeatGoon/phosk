package com.teamproject.phosk.branch.join.service;

import com.teamproject.phosk.branch.login.vo.BranchLoginVO;

public interface BranchJoinService {
	public BranchLoginVO branchCheckIDForEmail(BranchLoginVO bvo);

	public boolean branchOnerRegister(BranchLoginVO bvo);
}
