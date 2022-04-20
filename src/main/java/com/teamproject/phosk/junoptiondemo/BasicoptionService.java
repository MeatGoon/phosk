package com.teamproject.phosk.junoptiondemo;

import java.util.List;

import com.teamproject.phosk.junoptiondemo.BasicOptionVO;

public interface BasicoptionService {
	
	public void insertBasicoption(BasicOptionVO basicoptionvo);
	
	List<BasicOptionVO> menuEditPopup();

}
