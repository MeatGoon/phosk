package com.teamproject.phosk.user.member.service;

import java.util.List;

import com.teamproject.phosk.user.member.vo.CardinfoVO;

public interface CardinfoService {

	public void insertCard(CardinfoVO cardinfovo);
	
	List<CardinfoVO> cardinfoForm();
	
	public void  carddel(int cardinfo_cardNum);
	
	public void  cardall(String member_id);
}
