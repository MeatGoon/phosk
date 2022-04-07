package com.teamproject.phosk.user.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.teamproject.phosk.user.vo.CardinfoVO;

@Repository
public class CardinfoDAOImpl implements CardinfoDAO{
	
	@Autowired
	private SqlSession session;

	@Override
	public void insertCard(CardinfoVO cardinfovo) {
		session.insert("insertCard", cardinfovo);
		
	}
	@Override
	public List<CardinfoVO> cardinfoForm() {
		
		return session.selectList("cardinfoForm");
	}
}
