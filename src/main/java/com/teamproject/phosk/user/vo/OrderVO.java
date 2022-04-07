package com.teamproject.phosk.user.vo;

import java.util.Date;

import lombok.Data;
@Data
public class OrderVO {
	private String member_id;
	private String branch_num;
	private int item_num ;
	private int QRTable_Num;
	private Date order_time;
	private int order_status;
	private Date order_date;
	private int order_peoples;
	private int order_num; 

}
