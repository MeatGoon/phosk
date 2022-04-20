package com.teamproject.phosk.junoptiondemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamproject.phosk.junoptiondemo.BasicoptionDAO;
import com.teamproject.phosk.junoptiondemo.BasicOptionVO;




@Service
public class BasicoptionServiceImpl implements BasicoptionService{

	@Autowired
	private BasicoptionDAO basicoptiondao;
	
	@Override
	public void insertBasicoption(BasicOptionVO basicoptionvo) {
		basicoptiondao.insertBasicoption(basicoptionvo);
	}
	@Override
	public List<BasicOptionVO> menuEditPopup(){
		
		return basicoptiondao.menuEditPopup();
	}
	
	
}
