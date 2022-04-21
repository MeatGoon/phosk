package com.teamproject.phosk.user.main.dao;

import java.util.List;

import com.teamproject.phosk.branch.info.vo.BranchInfoVO;
import com.teamproject.phosk.branch.qr.vo.BranchQRVO;
import com.teamproject.phosk.user.main.paging.Criteria;

public interface UsermainDAO {

	//가게 목록
	List<BranchInfoVO> branchlist();
	//가게목록 + 페이징
	List<BranchInfoVO> branchpaging(Criteria cri);
	//가게 총 갯수
	int listcount();
	//qr테이블list
	List<BranchQRVO> qrlist();
}
