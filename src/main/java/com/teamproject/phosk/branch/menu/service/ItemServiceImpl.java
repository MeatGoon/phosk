package com.teamproject.phosk.branch.menu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamproject.phosk.branch.menu.dao.ItemDAO;
import com.teamproject.phosk.branch.menu.vo.BranchItemInfo;
import com.teamproject.phosk.branch.menu.vo.CategoryVO;
import com.teamproject.phosk.branch.menu.vo.ItemOptionVO;
import com.teamproject.phosk.branch.menu.vo.ItemVO;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemDAO itemMapper;

	@Override
	public List<CategoryVO> cateList(String branch_num) {
		return itemMapper.cateList(branch_num);
	}

	@Override
	public int chkDel(ItemVO itemVO) {
		return itemMapper.chkDel(itemVO);
	}

	@Override
	public int insrtCategory(CategoryVO cateVo) {
		return itemMapper.insrtCategory(cateVo);
	}

	@Override
	public List<ItemVO> getMenue(BranchItemInfo itemInfo) {
		return itemMapper.getMenue(itemInfo);

	}

	@Override
	public int updateCateName(CategoryVO cateVO) {
		return itemMapper.updateCateName(cateVO);
	}

	@Override
	public int addBestMenu(ItemVO itemVO) {
		return itemMapper.addBestMenu(itemVO);
	}

	@Override
	public BranchItemInfo menuDetail(BranchItemInfo itemInfo) {
		return itemMapper.menuDetail(itemInfo);
	}

	@Override
	public List<BranchItemInfo> getBOption(BranchItemInfo itemInfo) {
		return itemMapper.getBOption(itemInfo);
	}

	@Override
	public List<BranchItemInfo> getAOption(BranchItemInfo itemInfo) {
		return itemMapper.getAOption(itemInfo);
	}

	@Override
	public int updateBOption(BranchItemInfo itemInfo) {
		return itemMapper.updateBOption(itemInfo);
	}

	@Override
	public int updateAOption(BranchItemInfo itemInfo) {
		return itemMapper.updateAOption(itemInfo);
	}

	@Override
	public int updateItem(BranchItemInfo itemInfo) {
		return itemMapper.updateItem(itemInfo);
	}

	@Override
	public int updateCategory(BranchItemInfo itemInfo) {
		return itemMapper.updateCategory(itemInfo);
	}

	@Override
	public int deleteCategory(BranchItemInfo itemInfo) {
		return itemMapper.deleteCategory(itemInfo);
	}
	
	@Override
	public int deleteItem(BranchItemInfo itemInfo) {
		return itemMapper.deleteItem(itemInfo);
	}

	@Override
	public List<BranchItemInfo> getItemPrice(BranchItemInfo itemInfo) {
		return itemMapper.getItemPrice(itemInfo);
	}

	@Override
	public int deleteBestMenu(ItemVO itemVO) {
		return itemMapper.deleteBestMenu(itemVO);
	}

	@Override
	public int deleteAOption(ItemOptionVO optionInfo) {
		return itemMapper.deleteAOption(optionInfo);
	}
	
	@Override
	public int deleteBOption(ItemOptionVO optionInfo) {
		return itemMapper.deleteBOption(optionInfo);
	}

	@Override
	public int insertAOption(ItemOptionVO optionVO) {
		return itemMapper.insertAOption(optionVO);
	}

	@Override
	public int insertMenu(BranchItemInfo itemInfo) {
		return itemMapper.insertMenu(itemInfo);
	}

	@Override
	public int upBOption(BranchItemInfo itemInfo) {
		return itemMapper.upBOption(itemInfo);
	}

	@Override
	public int upAOption(BranchItemInfo itemInfo) {
		return itemMapper.upAOption(itemInfo);
	}

	@Override
	public int insertBOption(ItemOptionVO optionVO) {
		return itemMapper.insertBOption(optionVO);
	}

	@Override
	public int moveManage(ItemOptionVO optionVO) {
		return itemMapper.moveManage(optionVO);
	}
}
