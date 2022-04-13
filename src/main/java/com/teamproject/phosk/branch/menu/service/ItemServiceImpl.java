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
	private ItemDAO testMapper;

	@Override
	public List<CategoryVO> cateList(String branch_num) {
		return testMapper.cateList(branch_num);
	}

	@Override
	public List<ItemVO> meList() {
		return testMapper.meList();
	}

	@Override
	public ItemVO detailInfo(String menue_name) {
		return testMapper.detailInfo(menue_name);
	}

	@Override
	public int modify(ItemVO menueVO) {
		return testMapper.modify(menueVO);

	}

	@Override
	public int delete(ItemVO menueVO) {
		return testMapper.delete(menueVO);
	}

	@Override
	public int insert(ItemVO menueVO) {
		return testMapper.insert(menueVO);
	}

	@Override
	public int chkDel(String menueVO) {
		return testMapper.chkDel(menueVO);
	}

	@Override
	public int insrtCategory(CategoryVO categoryVO) {
		return testMapper.insrtCategory(categoryVO);
	}

	@Override
	public List<ItemVO> getMenue(String cateTest) {
		System.out.println(cateTest + " 서비스의 값");
		return testMapper.getMenue(cateTest);

	}

	@Override
	public List<ItemVO> menuGetAll(String cateTest) {
		return testMapper.menuGetAll(cateTest);
	}

	@Override
	public int deleteCategory(CategoryVO cateVO) {
		return testMapper.deleteCategory(cateVO);
	}

	@Override
	public int updateCateName(CategoryVO cateVO) {
		return testMapper.updateCateName(cateVO);
	}

	@Override
	public int delBestMenu(String menueVO) {
		return testMapper.delBestMenu(menueVO);
	}

	@Override
	public int addBestMenu(String menueVO) {
		System.out.println(menueVO);
		return testMapper.addBestMenu(menueVO);
	}

	@Override
	public BranchItemInfo testquery(BranchItemInfo itemInfo) {
		return testMapper.testquery(itemInfo);
	}

	@Override
	public int testupdate(BranchItemInfo itemInfo) {
		return testMapper.testupdate(itemInfo);
	}

	@Override
	public List<ItemOptionVO> getBOption(BranchItemInfo itemInfo) {
		return testMapper.getBOption(itemInfo);
	}

	@Override
	public List<ItemOptionVO> getAOption(BranchItemInfo itemInfo) {
		return testMapper.getAOption(itemInfo);
	}

	@Override
	public int updateBOption(BranchItemInfo itemInfo) {
		return testMapper.updateBOption(itemInfo);
	}

	@Override
	public int updateAOption(BranchItemInfo itemInfo) {
		return testMapper.updateAOption(itemInfo);
	}

}
