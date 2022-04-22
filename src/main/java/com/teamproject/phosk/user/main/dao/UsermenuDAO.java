package com.teamproject.phosk.user.main.dao;

import java.util.List;

import com.teamproject.phosk.branch.menu.vo.CategoryVO;
import com.teamproject.phosk.branch.menu.vo.ItemVO;


public interface UsermenuDAO {
	
	List<CategoryVO> catemenulist();
	
	List<ItemVO> itemmenulist();
}
