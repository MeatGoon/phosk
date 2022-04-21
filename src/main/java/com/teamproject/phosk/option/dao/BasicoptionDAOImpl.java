package com.teamproject.phosk.option.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.teamproject.phosk.option.vo.BasicOptionVO;



@Repository
public class BasicoptionDAOImpl implements BasicoptionDAO{

	@Autowired
	private SqlSession session;
	
	@Override
	public void insertbasicoption(BasicOptionVO basicoptionvo) {
		session.insert("insertbasicoption", basicoptionvo);
	}
	

	/*
	 * @Override public List<BasicOptionVO> menuEditPopup() {
	 * 
	 * return session.selectList("basicoptionForm"); }
	 */	
}
