package com.teamproject.phosk.user.item.vo;

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
public class ItemAddOptionVO extends ItemVO{
	private int item_num;
	private String add_option1;
	private String add_option2;
	private String add_option3;
	private String add_option4;
	private String add_option5;
	private int add_price1;
	private int add_price2;
	private int add_price3;
	private int add_price4;
	private int add_price5;
}
