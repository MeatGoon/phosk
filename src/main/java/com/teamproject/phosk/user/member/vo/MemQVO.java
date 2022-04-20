package com.teamproject.phosk.user.member.vo;

import java.util.Date;

import lombok.Data;

@Data
public class MemQVO {
	private int memQ_boardNum;
	private String memQ_title;
	private String memQ_content;
	private String member_id;
	private String branch_num; 
	private Date memQ_regiDate;
}
