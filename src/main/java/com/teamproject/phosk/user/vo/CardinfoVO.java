package com.teamproject.phosk.user.vo;

import lombok.Data;

	@Data
	public class CardinfoVO {
		private String cardinfo_bank;
		private String cardinfo_holderName;
		private String cardinfo_cardNum;
		private String cardinfo_dealine;
		private int cardinfo_cardCVC;
		private String cardinfo_accountpwd;
		private int cardinfo_cardpwd;
	}
