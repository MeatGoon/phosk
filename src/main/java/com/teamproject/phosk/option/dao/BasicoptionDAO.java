package com.teamproject.phosk.option.dao;

import java.util.List;

import com.teamproject.phosk.option.vo.BasicOptionVO;

public interface BasicoptionDAO {

	void insertBasicoption(BasicOptionVO basicoptionvo);
	
	List<BasicOptionVO> menuEditPopup();
}
