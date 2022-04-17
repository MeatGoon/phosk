package com.teamproject.phosk.user.service;

import java.util.List;

import com.teamproject.phosk.user.vo.CardinfoVO;

public interface CardinfoService {

	public void insertCard(CardinfoVO cardinfovo);
	
	List<CardinfoVO> cardinfoForm();
	
	public int  writecard(CardinfoVO cardinfovo);
}
