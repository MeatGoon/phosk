package com.teamproject.phosk.branch.qr.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.teamproject.phosk.branch.qr.vo.BranchQRVO;

@Repository
public class BranchQRDAOImpl implements BranchQRDAO {

	@Autowired
	private SqlSession session;
	
	@Override
	public List<BranchQRVO> branchSelectQRinfo(String branch_num) {
		return session.selectList("branchSelectQRinfo", branch_num);
	}

	@Override
	public BranchQRVO branchSelectOneQRinfo(BranchQRVO qvo) {
		return session.selectOne("branchSelectOneQRinfo", qvo);
	}

	@Override
	public int branchModifyQRInfo(BranchQRVO qvo) {
		return session.update("branchModifyQRInfo", qvo);
	}

	@Override
	public int branchRemoveQRInfo(int qrTable_index) {
		return session.delete("branchRemoveQRInfo", qrTable_index);
	}

	@Override
	public int branchResisterQRInfo(BranchQRVO qvo) {
		return session.insert("branchResisterQRInfo", qvo);
	}

}
