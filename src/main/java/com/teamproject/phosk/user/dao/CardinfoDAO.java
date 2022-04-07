package com.teamproject.phosk.user.dao;

import java.util.List;

import com.teamproject.phosk.user.vo.CardinfoVO;

public interface CardinfoDAO {

	void insertCard(CardinfoVO cardinfovo);

	List<CardinfoVO> cardinfoForm();
}
