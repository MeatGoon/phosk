package com.teamproject.phosk.option.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamproject.phosk.option.vo.AddOptionVO;


@Service
public class AddoptionServiceImpl implements AddoptionService{

	@Autowired
	private SqlSession session;
	
	@Override
	public void insertAddoption(AddOptionVO addoptionvo) {
		session.insert("insertaddoption",addoptionvo);
		
	}
	
	
}
