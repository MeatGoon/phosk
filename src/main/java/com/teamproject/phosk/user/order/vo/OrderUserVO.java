package com.teamproject.phosk.user.order.vo;

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
public class OrderUserVO extends OrderVO{
	private String member_nic;
	private String member_id;
	private String member_pwd;    
}
