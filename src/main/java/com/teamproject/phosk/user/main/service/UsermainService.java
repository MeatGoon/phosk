package com.teamproject.phosk.user.main.service;

import java.util.List;

import com.teamproject.phosk.branch.info.vo.BranchInfoVO;
import com.teamproject.phosk.branch.qr.vo.BranchQRVO;
import com.teamproject.phosk.user.main.paging.Criteria;

public interface UsermainService {
	
	List<BranchInfoVO> branchlist();
	
	List<BranchInfoVO> branchpaging(Criteria cri);
	
	int listcount();
	//qr테이블list
	List<BranchQRVO> qrlist();
}
