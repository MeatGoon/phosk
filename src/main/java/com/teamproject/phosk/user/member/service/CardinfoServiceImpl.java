	package com.teamproject.phosk.user.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamproject.phosk.user.member.dao.CardinfoDAO;
import com.teamproject.phosk.user.member.vo.CardinfoVO;

@Service
public class CardinfoServiceImpl implements CardinfoService{
	
	@Autowired
	private CardinfoDAO cardinfodao;

	@Override
	public void insertCard(CardinfoVO cardinfovo) {
		cardinfodao.insertCard(cardinfovo);
		
	}
	@Override
	public List<CardinfoVO> cardinfoForm() {
		
		return cardinfodao.cardinfoForm();
	}
	@Override
	public void carddel(int cardinfo_cardNum) {
		cardinfodao.carddel(cardinfo_cardNum);

	}
	@Override
	public void cardall(String member_id) {
		cardinfodao.cardall(member_id);
	}

}
