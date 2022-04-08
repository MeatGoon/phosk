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
public class ItemCategoryVO extends ItemBasicOptionVO {
	private String branch_num;
	private int category_num;
	private String category_name;
}
