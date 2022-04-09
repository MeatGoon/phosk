package com.teamproject.phosk.branch.menu.vo;

import lombok.Data;

@Data
public class BranchItemInfo {
	
	//category_num
	private String branch_num;
	private int category_num;
	private String category_name;
	
	//phosk_item
	private int item_num;
	private String item_name;
	private String item_image;
	private String item_info;
	private String item_lastDate;
	private String item_regiDate;
	
	//phosk_basicoption
	private String basic_option1;//not null
	private String basic_option2;
	private String basic_option3;
	private String basic_option4;
	private int basic_price1;//not null
	private int basic_price2;
	private int basic_price3;
	private int basic_price4;
	
	//phosk_addoption
	private String add_option1;//not null
	private String add_option2;
	private String add_option3;
	private String add_option4;
	private String add_option5;
	private int add_price1;//not null
	private int add_price2;
	private int add_price3;
	private int add_price4;
	private int add_price5;
}
