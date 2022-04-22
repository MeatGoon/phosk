package com.teamproject.phosk.user.main.service;

import java.util.List;

import com.teamproject.phosk.branch.menu.vo.CategoryVO;
import com.teamproject.phosk.branch.menu.vo.ItemVO;

public interface UsermenuService {
	
	List<CategoryVO> catemenulist();
	
	List<ItemVO> itemmenulist();
}
