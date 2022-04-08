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
public class ItemBasicOptionVO extends ItemAddOptionVO {
	private int item_num;
	private String basic_option1;
	private String basic_option2;
	private String basic_option3;
	private String basic_option4;
	private int basic_price1;
	private int basic_price2;
	private int basic_price3;
	private int basic_price4;
}
