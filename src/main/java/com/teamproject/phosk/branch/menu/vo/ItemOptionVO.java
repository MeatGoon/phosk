package com.teamproject.phosk.branch.menu.vo;

import lombok.Data;

@Data
public class ItemOptionVO {
	private String branch_num;
	private int category_num;
	private int item_num;
	
	/* 기본 가격 */
	private String basic_option;//not null
	private int basic_price;//not null
	
	/* 추가 옵션 */
	private String add_option;//not null
	private int add_price;//not null
}
