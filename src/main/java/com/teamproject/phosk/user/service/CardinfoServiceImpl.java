package com.teamproject.phosk.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamproject.phosk.user.dao.CardinfoDAO;
import com.teamproject.phosk.user.vo.CardinfoVO;

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
	public int writecard(CardinfoVO cardinfovo) {
		return cardinfodao.writecard(cardinfovo);
	}

}
