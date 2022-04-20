package com.teamproject.phosk.option.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamproject.phosk.option.dao.BasicoptionDAO;
import com.teamproject.phosk.option.vo.BasicOptionVO;




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
