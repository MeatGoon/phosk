package com.teamproject.phosk.branch.menu.vo;

import lombok.Data;

@Data
public class ItemVO {
	private String branch_num;
	private int category_num;
	private int item_num;
	private String item_name;
	private String item_image;
	private String item_info;
	private String item_lastDate;
	private String item_regiDate;
}