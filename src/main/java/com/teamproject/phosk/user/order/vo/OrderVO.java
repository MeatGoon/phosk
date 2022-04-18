package com.teamproject.phosk.user.order.vo;


import com.teamproject.phosk.user.item.vo.ItemCategoryVO;

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
public class OrderVO extends ItemCategoryVO{
	private String member_id;
	private String branch_num;
	private int item_num;
	private int qrtable_num;
	private String qrtable_url;
	private String order_time;	//주문 시간 db에선 date형식으로 되어있음.
	private int order_status;	//주문 상태	0대기 1확인 2결제
	private String order_date;	//주문 날짜
	private int order_peples;	//주문 인원
	private int order_num;		//주문 번호
}
