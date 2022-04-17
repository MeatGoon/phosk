package com.teamproject.phosk.branch.menu.service;

import java.util.List;

import com.teamproject.phosk.branch.menu.vo.BranchItemInfo;
import com.teamproject.phosk.branch.menu.vo.CategoryVO;
import com.teamproject.phosk.branch.menu.vo.ItemOptionVO;
import com.teamproject.phosk.branch.menu.vo.ItemVO;

public interface ItemService {

	public List<CategoryVO> cateList(String branch_num);

	public List<ItemVO> meList();

	public ItemVO detailInfo(String menue_name);

	public int modify(ItemVO menueVO);

	public int delete(ItemVO menueVO);

	public int insert(ItemVO menueVO);

	public int chkDel(String menueVO);

	public int insrtCategory(CategoryVO categoryVO);

	public List<ItemVO> getMenue(BranchItemInfo itemInfo);

	public List<ItemVO> menuGetAll(BranchItemInfo itemInfo);

	public int deleteCategory(BranchItemInfo itemInfo);

	public int updateCateName(CategoryVO cateVO);

	public int delBestMenu(String menueVO);

	public int addBestMenu(String menueVO);

	public BranchItemInfo testquery(BranchItemInfo itemInfo);

	public int testupdate(BranchItemInfo itemInfo);

	public List<BranchItemInfo> getBOption(BranchItemInfo itemInfo);

	public List<BranchItemInfo> getAOption(BranchItemInfo itemInfo);

	public int updateBOption(BranchItemInfo itemInfo);

	public int updateAOption(BranchItemInfo itemInfo);

	public int updateItem(BranchItemInfo itemInfo);

	public int updateCategory(BranchItemInfo itemInfo);

	public int deleteItem(BranchItemInfo itemInfo);

}
