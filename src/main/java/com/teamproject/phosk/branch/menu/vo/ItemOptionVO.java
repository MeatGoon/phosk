package com.teamproject.phosk.branch.menu.vo;

import lombok.Data;

@Data
public class ItemOptionVO {

	/* 기본 가격 */
	private String basic_option1;//not null
	private String basic_option2;
	private String basic_option3;
	private String basic_option4;
	private int basic_price1;//not null
	private int basic_price2;
	private int basic_price3;
	private int basic_price4;
	
	/* 추가 옵션 */
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
