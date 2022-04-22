package com.teamproject.phosk.option.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamproject.phosk.option.dao.AddoptionDAO;
import com.teamproject.phosk.option.vo.AddOptionVO;


@Service
public class AddoptionServiceImpl implements AddoptionService{

	@Autowired
	private AddoptionDAO addoptiondao;
	
	@Override
	public void insertAddoption(AddOptionVO addoptionvo) {
		
		addoptiondao.insertaddoption(addoptionvo);
		
	}
	
	
}
