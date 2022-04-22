package com.teamproject.phosk.branch.menu.dao;

import java.util.List;

import com.teamproject.phosk.branch.menu.vo.BranchItemInfo;
import com.teamproject.phosk.branch.menu.vo.CategoryVO;
import com.teamproject.phosk.branch.menu.vo.ItemOptionVO;
import com.teamproject.phosk.branch.menu.vo.ItemVO;

public interface ItemDAO {
	
	List<CategoryVO> cateList(String branch_num);

	int chkDel(ItemVO itemVO);

	int insrtCategory(CategoryVO cateVo);

	List<ItemVO> getMenue(BranchItemInfo itemInfo);

	List<ItemVO> menuGetAll(BranchItemInfo itemInfo);

	int deleteCategory(BranchItemInfo itemInfo);

	int updateCateName(CategoryVO cateVO);

	int delBestMenu(String menueVO);

	int addBestMenu(ItemVO itemVO);

	BranchItemInfo menuDetail(BranchItemInfo itemInfo);

	List<BranchItemInfo> getBOption(BranchItemInfo itemInfo);

	List<BranchItemInfo> getAOption(BranchItemInfo itemInfo);

	int updateBOption(BranchItemInfo itemInfo);

	int updateAOption(BranchItemInfo itemInfo);

	int updateItem(BranchItemInfo itemInfo);

	int updateCategory(BranchItemInfo itemInfo);

	int deleteItem(BranchItemInfo itemInfo);

	List<BranchItemInfo> getItemPrice(BranchItemInfo itemInfo);

	int deleteBestMenu(ItemVO itemVO);

	int deleteAOption(ItemOptionVO optionInfo);

	int deleteBOption(ItemOptionVO optionInfo);

	int insertAOption(ItemOptionVO optionVO);

	int insertMenu(BranchItemInfo itemInfo);

	int upBOption(BranchItemInfo itemInfo);

	int upAOption(BranchItemInfo itemInfo);

	int insertBOption(ItemOptionVO optionVO);

	int moveManage(ItemOptionVO optionVO);
}
