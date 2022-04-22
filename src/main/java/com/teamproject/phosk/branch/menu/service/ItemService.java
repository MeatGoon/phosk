package com.teamproject.phosk.branch.menu.service;

import java.util.List;

import com.teamproject.phosk.branch.menu.vo.BranchItemInfo;
import com.teamproject.phosk.branch.menu.vo.CategoryVO;
import com.teamproject.phosk.branch.menu.vo.ItemOptionVO;
import com.teamproject.phosk.branch.menu.vo.ItemVO;

public interface ItemService {

	// 카테고리 목록
	public List<CategoryVO> cateList(String branch_num);

	// 메뉴 목록
	public List<ItemVO> getMenue(BranchItemInfo itemInfo);
	
	// 메뉴 가격
	public List<BranchItemInfo> getItemPrice(BranchItemInfo itemInfo);
	
	// 메뉴의 상세목록
	public BranchItemInfo menuDetail(BranchItemInfo itemInfo);

	// 기본옵션 정보
	public List<BranchItemInfo> getBOption(BranchItemInfo itemInfo);

	// 추가옵션 정보
	public List<BranchItemInfo> getAOption(BranchItemInfo itemInfo);

	// 카테고리명 수정
	public int updateCateName(CategoryVO cateVO);
	
	// 아이템의 카테고리 이동
	public int updateCategory(BranchItemInfo itemInfo);
	
	// 아이템 정보 수정
	public int updateItem(BranchItemInfo itemInfo);
	
	// 아이템 기본옵션 수정
	public int updateBOption(BranchItemInfo itemInfo);

	// 아이템 추가옵션 수정
	public int updateAOption(BranchItemInfo itemInfo);

	// 새 카테고리 추가
	public int insrtCategory(CategoryVO cateVo);

	// 카테고리 삭제
	public int deleteCategory(BranchItemInfo itemInfo);

	// 메뉴 삭제
	public int deleteItem(BranchItemInfo itemInfo);

	// 기본옵션 삭제
	
	// 추가옵션 삭제
	
	// 인기 메뉴 추가
	public int addBestMenu(ItemVO itemVO);
	
	// 인기 메뉴 삭제
	public int deleteBestMenu(ItemVO itemVO);

	// 메뉴 선택 삭제
	public int chkDel(ItemVO itemVO);

	public int deleteAOption(ItemOptionVO optionInfo);

	public int deleteBOption(ItemOptionVO optionInfo);
}
