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
		
//		basicoptionvo.setBranch_num("123-45-67890");
//		basicoptionvo.setCategory_num(2);
//		basicoptionvo.setItem_num(2);
//		basicoptionvo.setBasic_option("기본");
//		basicoptionvo.setBasic_price(4000);
		
		basicoptiondao.insertbasicoption(basicoptionvo);
		
	}
	/*
	 * @Override public List<BasicOptionVO> menuEditPopup(){
	 * 
	 * return basicoptiondao.menuEditPopup(); }
	 */
	
	
}
