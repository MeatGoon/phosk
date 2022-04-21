package com.teamproject.phosk.branch.qr.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.teamproject.phosk.branch.qr.dao.BranchQRDAO;
import com.teamproject.phosk.branch.qr.vo.BranchQRVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@RequiredArgsConstructor
public class BranchQRServiceImpl implements BranchQRService {
	
	private final BranchQRDAO dao;
	
	@Override
	public List<BranchQRVO> branchSelectQRinfo(String branch_num) {
		log.info("branchSelectQRinfo......" + branch_num);
		return dao.branchSelectQRinfo(branch_num);
	}

	@Override
	public BranchQRVO branchSelectOneQRinfo(BranchQRVO qvo) {
		log.info("branchSelectOneQRinfo......" + qvo.getBranch_num() + " + " + qvo.getQrTable_num());
		return dao.branchSelectOneQRinfo(qvo);
	}

	@Override
	public boolean branchModifyQRInfo(BranchQRVO qvo) {
		return dao.branchModifyQRInfo(qvo) == 1;
	}

	@Override
	public boolean branchRemoveQRInfo(int qrTable_index) {
		return dao.branchRemoveQRInfo(qrTable_index) == 1;
	}

	@Override
	public boolean branchResisterQRInfo(BranchQRVO qvo) {
		return dao.branchResisterQRInfo(qvo) == 1;
	}

}
