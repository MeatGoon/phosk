package com.teamproject.phosk.branch.qr.service;

import java.util.List;

import com.teamproject.phosk.branch.qr.vo.BranchQRVO;

public interface BranchQRService {
	public List<BranchQRVO> branchSelectQRinfo(String branch_num);

	public BranchQRVO branchSelectOneQRinfo(BranchQRVO qvo);

	public boolean branchModifyQRInfo(BranchQRVO qvo);

	public boolean branchRemoveQRInfo(int qrTable_index);

	public boolean branchResisterQRInfo(BranchQRVO qvo);
}
