package com.teamproject.phosk.branch.menu.vo;

import lombok.Data;

@Data
public class BranchItemInfo {
	
	// phosk_category
	private String branch_num;
	private int category_num;
	private String category_name;
	
	// phosk_item
	private int item_num;
	private String item_name;
	private String item_image;
	private String item_info;
	private String item_lastDate;
	private String item_regiDate;
	
	// phosk_basicoption
	private String basic_option;//not null
	private int basic_price;//not null
	
	// phosk_basicoption명 변경 시
	private String change_basic_option;
	
	// phosk_addoption
	private String add_option;//not null
	private int add_price;
	
	// phosk_addoption명 변경 시
	private String change_add_option;
}
