package com.teamproject.phosk.user.item.vo;

import com.teamproject.phosk.branch.info.vo.BranchInfoVO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class ItemVO extends BranchInfoVO {
	private int cateory_num;
	private int item_num;
	private String item_name;
	private String item_image;
	private String item_info;
	private String item_lastDate;
	private String item_regiDate;
}
