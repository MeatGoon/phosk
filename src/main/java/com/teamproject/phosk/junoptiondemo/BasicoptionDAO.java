package com.teamproject.phosk.junoptiondemo;

import java.util.List;

import com.teamproject.phosk.junoptiondemo.BasicOptionVO;

public interface BasicoptionDAO {

	void insertBasicoption(BasicOptionVO basicoptionvo);
	
	List<BasicOptionVO> menuEditPopup();
}
