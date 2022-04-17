package com.teamproject.phosk.branch.menu.dao;

import java.util.List;

import com.teamproject.phosk.branch.menu.vo.BranchItemInfo;
import com.teamproject.phosk.branch.menu.vo.CategoryVO;
import com.teamproject.phosk.branch.menu.vo.ItemOptionVO;
import com.teamproject.phosk.branch.menu.vo.ItemVO;

public interface ItemDAO {
	
	List<CategoryVO> cateList(String branch_num);

	List<ItemVO> meList();

	ItemVO detailInfo(String menue_name);

	int modify(ItemVO menueVO);

	int delete(ItemVO menueVO);

	int insert(ItemVO menueVO);

	int chkDel(String menueVO);

	int insrtCategory(CategoryVO categoryVO);

	List<ItemVO> getMenue(BranchItemInfo itemInfo);

	List<ItemVO> menuGetAll(BranchItemInfo itemInfo);

	int deleteCategory(BranchItemInfo itemInfo);

	int updateCateName(CategoryVO cateVO);

	int delBestMenu(String menueVO);

	int addBestMenu(String menueVO);

	BranchItemInfo testquery(BranchItemInfo itemInfo);

	int testupdate(BranchItemInfo itemInfo);

	List<BranchItemInfo> getBOption(BranchItemInfo itemInfo);

	List<BranchItemInfo> getAOption(BranchItemInfo itemInfo);

	int updateBOption(BranchItemInfo itemInfo);

	int updateAOption(BranchItemInfo itemInfo);

	int updateItem(BranchItemInfo itemInfo);

	int updateCategory(BranchItemInfo itemInfo);

	int deleteItem(BranchItemInfo itemInfo);
 
}
