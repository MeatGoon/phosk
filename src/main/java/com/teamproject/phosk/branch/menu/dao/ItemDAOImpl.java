package com.teamproject.phosk.branch.menu.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.teamproject.phosk.branch.menu.vo.BranchItemInfo;
import com.teamproject.phosk.branch.menu.vo.CategoryVO;
import com.teamproject.phosk.branch.menu.vo.ItemOptionVO;
import com.teamproject.phosk.branch.menu.vo.ItemVO;

@Repository
public class ItemDAOImpl implements ItemDAO {

	@Autowired
	private SqlSession session;

	@Override
	public List<CategoryVO> cateList(String branch_num) {
		return session.selectList("getCategory", branch_num);
	}
	
	@Override
	public int chkDel(ItemVO itemVO) {
		return session.delete("deleteItem", itemVO);
	}

	@Override
	public int insrtCategory(CategoryVO cateVo) {
		return session.insert("insertCategory", cateVo);
	}

	@Override
	public List<ItemVO> getMenue(BranchItemInfo itemInfo) {
		return session.selectList("getItem", itemInfo);
	}

	@Override
	public List<ItemVO> menuGetAll(BranchItemInfo itemInfo) {
		return session.selectList("getItem", itemInfo);
	}

	@Override
	public int deleteCategory(BranchItemInfo itemInfo) {
		return session.delete("deleteCategory", itemInfo);
	}

	@Override
	public int updateCateName(CategoryVO cateVO) {
		return session.update("updateCategory", cateVO);
	}

	@Override
	public int delBestMenu(String menueVO) {
		return session.delete("deleteBestMenu", menueVO);
	}

	@Override
	public int addBestMenu(ItemVO itemVO) {
		System.out.println(itemVO);
		return session.insert("addBestMenu", itemVO);
	}

	@Override
	public BranchItemInfo menuDetail(BranchItemInfo itemInfo) {
		return session.selectOne("itemDetailInfo",itemInfo);
	}

	@Override
	public List<BranchItemInfo> getBOption(BranchItemInfo itemInfo) {
		return session.selectList("basicItemOption",itemInfo);
	}

	@Override
	public List<BranchItemInfo> getAOption(BranchItemInfo itemInfo) {
		return session.selectList("addItemOption",itemInfo);
	}

	@Override
	public int updateBOption(BranchItemInfo itemInfo) {
		return session.update("updateBOption", itemInfo);
	}

	@Override
	public int updateAOption(BranchItemInfo itemInfo) {
		return session.update("updateAOption", itemInfo);
	}

	@Override
	public int updateItem(BranchItemInfo itemInfo) {
		return session.update("updateItem", itemInfo);
	}

	@Override
	public int updateCategory(BranchItemInfo itemInfo) {
		return session.update("updateCategory", itemInfo);
	}

	@Override
	public int deleteItem(BranchItemInfo itemInfo) {
		return session.update("deleteItem", itemInfo);
	}

	@Override
	public List<BranchItemInfo> getItemPrice(BranchItemInfo itemInfo) {
		return session.selectList("getItemPrice", itemInfo);
	}

	@Override
	public int deleteBestMenu(ItemVO itemVO) {
		return session.delete("deleteBestMenu", itemVO);
	}

	@Override
	public int deleteAOption(ItemOptionVO optionInfo) {
		return session.delete("deleteAOption", optionInfo);
	}
	
	@Override
	public int deleteBOption(ItemOptionVO optionInfo) {
		return session.delete("deleteBOption", optionInfo);
	}

	@Override
	public int insertAOption(ItemOptionVO optionVO) {
		return session.insert("insertAOption", optionVO);
	}

	@Override
	public int insertMenu(BranchItemInfo itemInfo) {
		return session.insert("insertItem", itemInfo);
	}

	@Override
	public int upBOption(BranchItemInfo itemInfo) {
		return session.update("insertUpBOption", itemInfo);
	}

	@Override
	public int upAOption(BranchItemInfo itemInfo) {
		return session.update("insertUpAOption", itemInfo);
	}

	@Override
	public int insertBOption(ItemOptionVO optionVO) {
		return session.insert("insertBOption", optionVO);
	}

	@Override
	public int moveManage(ItemOptionVO optionVO) {
		return session.insert("moveManage", optionVO);
	}
}
