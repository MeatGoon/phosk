package com.teamproject.phosk.branch.qr.dao;

import java.util.List;

import com.teamproject.phosk.branch.qr.vo.BranchQRVO;

public interface BranchQRDAO {
	public List<BranchQRVO> branchSelectQRinfo(String branch_num);

	public BranchQRVO branchSelectOneQRinfo(BranchQRVO qvo);

	public int branchModifyQRInfo(BranchQRVO qvo);

	public int branchRemoveQRInfo(int qrTable_index);

	public int branchResisterQRInfo(BranchQRVO qvo);
}
