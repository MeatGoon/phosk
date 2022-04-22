package com.teamproject.phosk.user.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamproject.phosk.branch.menu.vo.CategoryVO;
import com.teamproject.phosk.branch.menu.vo.ItemVO;
import com.teamproject.phosk.user.main.dao.UsermenuDAO;

@Service
public class UsermenuServiceImpl implements UsermenuService{
	@Autowired
	private UsermenuDAO usermenudao;
	
	@Override
	public List<CategoryVO> catemenulist(){
		return usermenudao.catemenulist();
	}
	@Override
	public List<ItemVO> itemmenulist(){
		return usermenudao.itemmenulist();
	}
}
