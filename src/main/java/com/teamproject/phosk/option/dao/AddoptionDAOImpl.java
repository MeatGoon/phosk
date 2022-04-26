package com.teamproject.phosk.option.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.teamproject.phosk.option.vo.AddOptionVO;


@Repository
public class AddoptionDAOImpl implements AddoptionDAO{

	@Autowired
	private SqlSession session;

	
	@Override
	public void insertaddoption(AddOptionVO addoptionvo) {
		session.insert("insertAddOption", addoptionvo);
	}
	
	
}
