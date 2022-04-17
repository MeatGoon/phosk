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
	public List<ItemVO> meList() {
		return session.selectList("meList");
	}

	@Override
	public ItemVO detailInfo(String menue_name) {
		return session.selectOne("detailInfo", menue_name);
	}

	@Override
	public int modify(ItemVO menueVO) {
		return session.update("menueModify", menueVO);
	}

	@Override
	public int delete(ItemVO menueVO) {
		return session.delete("menueDelete", menueVO);
	}

	@Override
	public int insert(ItemVO menueVO) {
		return session.insert("menueInsert", menueVO);
	}

	@Override
	public int chkDel(String menueVO) {
		return session.delete("menueDelete", menueVO);
	}

	@Override
	public int insrtCategory(CategoryVO categoryVO) {
		return session.insert("insrtCategory", categoryVO);
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
	public int addBestMenu(String menueVO) {
		System.out.println(menueVO);
		return session.insert("addBestMenu", menueVO);
	}

	@Override
	public BranchItemInfo testquery(BranchItemInfo itemInfo) {
		return session.selectOne("itemDetailInfo",itemInfo);
	}

	@Override
	public int testupdate(BranchItemInfo itemInfo) {
		return session.update("updateTest", itemInfo);
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
}
