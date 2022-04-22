package com.teamproject.phosk.user.main.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.teamproject.phosk.branch.menu.vo.CategoryVO;
import com.teamproject.phosk.branch.menu.vo.ItemVO;

@Repository
public class UsermenuDAOImpl implements UsermenuDAO{
	
	@Autowired
	private SqlSession session;
	
	@Override
	public List<CategoryVO> catemenulist(){
		return session.selectList("catemenulist");
	}
	@Override
	public List<ItemVO> itemmenulist(){
		return session.selectList("itemmenulist");
	}


}
