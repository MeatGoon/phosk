package com.teamproject.phosk.junoptiondemo;

import com.teamproject.phosk.branch.info.vo.BranchInfoVO;

import lombok.Data;



@Data
public class QRTableVO {
	BranchInfoVO branchinfoVO;
	private int QRTable_Num;
	private String QRTable_URL;
}
