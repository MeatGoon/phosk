package com.teamproject.phosk.user.dao;

import java.util.List;

import com.teamproject.phosk.user.vo.CardinfoVO;

public interface CardinfoDAO {

	void insertCard(CardinfoVO cardinfovo);

	List<CardinfoVO> cardinfoForm();
	
	//카드삭제
	void  carddel(int cardinfo_cardNum);
	//카드전체삭제
	void  cardall(String member_id);
}
