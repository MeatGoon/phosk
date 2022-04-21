package com.teamproject.phosk.branch.qr.vo;

import com.teamproject.phosk.branch.info.vo.BranchInfoVO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;




@Setter
@Getter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class BranchQRVO extends BranchInfoVO {
	private int qrTable_index;
	private String branch_num;
	private int qrTable_num;
	private String qrTable_url;
}
