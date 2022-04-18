package com.teamproject.phosk.branch.menu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.teamproject.phosk.branch.menu.service.ItemService;
import com.teamproject.phosk.branch.menu.vo.BranchItemInfo;
import com.teamproject.phosk.branch.menu.vo.CategoryVO;
import com.teamproject.phosk.branch.menu.vo.ItemVO;
import com.teamproject.phosk.branch.menu.vo.NowPage;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/test/*")
@AllArgsConstructor
public class ItemController {

	@Autowired
	private ItemService service;

	@GetMapping("/test")
	public void test(BranchItemInfo itemInfo, String branch_num, Model model, HttpServletRequest request,
			NowPage nowPage) {
		log.info("test List .....");

		System.out.println(itemInfo);

		model.addAttribute("cateTest", service.testquery(itemInfo));
		model.addAttribute("bOptions", service.getBOption(itemInfo));
		model.addAttribute("aOptions", service.getAOption(itemInfo));

	}

	@PostMapping("/testUpdate")
	public String updateTest(BranchItemInfo itemInfo, String basic_price, String add_price) {
		System.out.println(itemInfo);
		System.out.println("basic_price ======" + basic_price);
		service.updateCategory(itemInfo);
		service.updateItem(itemInfo);
		/* 기본옵션 수정 */
		String[] getBO = itemInfo.getBasic_option().split(",");
		String[] getBOP = basic_price.split(",");
		String[] getCBO = itemInfo.getChange_basic_option().split(",");

		for (int i = 0; i < getBO.length; i++) {
			int setBOP = Integer.parseInt(getBOP[i]);
			itemInfo.setBasic_option(getBO[i]);
			itemInfo.setChange_basic_option(getCBO[i]);
			itemInfo.setBasic_price(setBOP);
			try {
				service.updateBOption(itemInfo);
			} catch (DuplicateKeyException e) {
				System.out.println(e);
			}
		}
		/* 추가옵션 수정 */
		String[] getAO = itemInfo.getAdd_option().split(",");
		String[] getAOP = add_price.split(",");
		String[] getCAO = itemInfo.getChange_add_option().split(",");
		for (int i = 0; i < getAO.length; i++) {
			int setAOP = Integer.parseInt(getAOP[i]);
			itemInfo.setAdd_option(getAO[i]);
			itemInfo.setChange_add_option(getCAO[i]);
			itemInfo.setAdd_price(setAOP);
			try {
				service.updateAOption(itemInfo);
			} catch (DuplicateKeyException e) {
				System.out.println(e);
				/* 중복 키로인한 IDE console 출력후 반환 */
			}
		}
		/*
		 * insert 할때 사용할 부분
		 * 
		 * if (addArr != "") { String[] ArrStr = addArr.split(","); for (int i = 0; i <
		 * ArrStr.length; i++) { System.out.println(ArrStr[i] + "?분리완료"); } }
		 */

		return "redirect:/test/test?branch_num=123-45-67890&category_num=2&item_num=1";
	}

	@PostMapping("/testDel")
	public String testDel() {

		return "redirect:/test/test?branch_num=123-45-67890&category_num=2&item_num=1";
	}

	// 메뉴 관리 메인 페이지
	@GetMapping("/cateList")
	public void cateList(BranchItemInfo itemInfo, Model model, HttpServletRequest request, NowPage nowPage) {
		log.info("cate List .....");
		String branch_num = itemInfo.getBranch_num();
		model.addAttribute("branchInfo", branch_num); // 사업자 번호만 반환
		model.addAttribute("cateNum", itemInfo.getCategory_num()); // 현재 카테고리 위치 반환
		model.addAttribute("cateTest", service.getMenue(itemInfo));
		model.addAttribute("cateList", service.cateList(branch_num));
		/* 필요한부분 */
		/* cateList = 카테고리 리스트 / cateTest = 메뉴 리스트 */
		/* 기본가격 따로 불러와야함 */
	}

	// 메뉴 관리 페이지 이동
	@GetMapping("/menueManage") /* 카테고리 숫자 받아서 반환할거 필요할거같음 */
	public void menueManage(BranchItemInfo itemInfo, Model model, HttpServletRequest request) {
		log.info("menueManage List .....");
		String branch_num = itemInfo.getBranch_num();
		model.addAttribute("branchInfo", branch_num); // 사업자 번호만 반환
		model.addAttribute("cateNum", itemInfo.getCategory_num()); // 현재 카테고리 위치 반환
		model.addAttribute("categoryName", itemInfo.getCategory_name()); // 인기메뉴 구별을 위한 카테고리 이름 정보
		model.addAttribute("cateTest", service.getMenue(itemInfo));
		model.addAttribute("cateList", service.cateList(branch_num));
	}

	// 메뉴 상세정보
	@GetMapping("/detailInfo")
	public void detailInfo(BranchItemInfo itemInfo, Model model) {
		model.addAttribute("cateTest", service.testquery(itemInfo));
		model.addAttribute("bOptions", service.getBOption(itemInfo));
		model.addAttribute("aOptions", service.getAOption(itemInfo));
	}

	// 메뉴수정
	@PostMapping("/itemUpdate")
	public String menueModify(BranchItemInfo itemInfo, String basic_price, String add_price) {
		System.out.println(itemInfo);
		String bNum = itemInfo.getBranch_num();
		int cNUm = itemInfo.getCategory_num();
		service.updateCategory(itemInfo);
		service.updateItem(itemInfo);
		/* 기본옵션 수정 */
		String[] getBO = itemInfo.getBasic_option().split(",");
		String[] getBOP = basic_price.split(",");
		String[] getCBO = itemInfo.getChange_basic_option().split(",");

		for (int i = 0; i < getBO.length; i++) {
			int setBOP = Integer.parseInt(getBOP[i]);
			itemInfo.setBasic_option(getBO[i]);
			itemInfo.setChange_basic_option(getCBO[i]);
			itemInfo.setBasic_price(setBOP);
			service.updateBOption(itemInfo);
		}
		/* 추가옵션 수정 */
		if (itemInfo.getAdd_option() != null) {
			String[] getAO = itemInfo.getAdd_option().split(",");
			String[] getAOP = add_price.split(",");
			String[] getCAO = itemInfo.getChange_add_option().split(",");
			for (int i = 0; i < getAO.length; i++) {
				int setAOP = Integer.parseInt(getAOP[i]);
				itemInfo.setAdd_option(getAO[i]);
				itemInfo.setChange_add_option(getCAO[i]);
				itemInfo.setAdd_price(setAOP);
				service.updateAOption(itemInfo);
			}

		}
		return "redirect:/test/cateList?branch_num=" + bNum + "&category_num=" + cNUm;
	}

	@GetMapping("/insertMenue")
	public void insertMenue(String branch_num, Model model, NowPage nowPage) {
		log.info("insertMenue List .....");
		List<CategoryVO> cateList = service.cateList(branch_num);
		model.addAttribute("cateList", cateList);
		model.addAttribute("nowPage", nowPage);
		/* 필요한부분 */
		/* cateList = 카테고리 리스트(카테고리 설정할때 사용) */
	}

	@PostMapping("/insrtCategory")
	public String insrtCategory(CategoryVO cateVo, RedirectAttributes rttr) {
		System.out.println(cateVo);
		service.insrtCategory(cateVo);
		return "redirect:/test/menueManage?branch_num=" + cateVo.getBranch_num() + "&category_num=" + cateVo.getCategory_num();
	}
	
	@PostMapping("/insertMenue")
	public String insertMenue(ItemVO menueVO, int cateTest, RedirectAttributes rttr, NowPage nowPage) {
		service.insert(menueVO);
		rttr.addFlashAttribute("result", "insert success");
		return "redirect:/test/menueManage?cateTest=" + cateTest;
	}
	
	// 카테고리명 수정
	@PostMapping("/updateCateName")
	public String updateCateName(CategoryVO cateVo, RedirectAttributes rttr) {
		service.updateCateName(cateVo);
		rttr.addFlashAttribute("result", "UpCateName success");
		return "redirect:/test/menueManage?branch_num=" + cateVo.getBranch_num() + "&category_num=" + cateVo.getCategory_num();
	}

	// 카테고리 삭제
	@PostMapping("/deleteCategory")
	public String deleteCategory(BranchItemInfo itemInfo, RedirectAttributes rttr) {
		service.deleteCategory(itemInfo);
		rttr.addFlashAttribute("result", "delCate success");
		return "redirect:/test/cateList?branch_num=" + itemInfo.getBranch_num();
	}
	
	// 아이템 삭제
	@PostMapping("/deleteItem")
	public String menueDelete(BranchItemInfo itemInfo, RedirectAttributes rttr) {
		service.deleteItem(itemInfo);
		rttr.addFlashAttribute("result", "delete success"); // delete success 메인페이지로 반환 됨
		return "redirect:/test/cateList?branch_num=" + itemInfo.getBranch_num() + "&category_num=" + itemInfo.getCategory_num();
	}

	// 값 하나만 보내다보니 조건문에 들어갈 값은 어떻게 해결해야할까..?
	@PostMapping("/deleteBestMenu")
	public String deleteBestMenu(HttpServletRequest request, RedirectAttributes rttr, NowPage nowPage) {
		String[] ajaxData = request.getParameterValues("checkedbtn");
		int nowCate = nowPage.getNowCate();
		for (int i = 0; i < ajaxData.length; i++) {
			service.delBestMenu(ajaxData[i]);
		}
		rttr.addFlashAttribute("result", "deleteBestMenu success");
		return "redirect:/test/menueManage?cateTest=" + nowCate;
	}

	// 값 하나만 보내다보니 조건문에 들어갈 값은 어떻게 해결해야할까..?
	@PostMapping("/deleteChk")
	public String menueDelete(ItemVO itemVO, HttpServletRequest request, RedirectAttributes rttr) {
		String[] ajaxData = request.getParameterValues("checkedbtn");
		String branchNum = request.getParameter("branchNum");
		String categoryNum = request.getParameter("categoryNum");
		System.out.println(ajaxData.length);
		for (int i = 0; i < ajaxData.length; i++) {
			System.out.println("================");
			System.out.println(i);
			itemVO.setBranch_num(branchNum);
			itemVO.setCategory_num(Integer.parseInt(categoryNum));
			itemVO.setItem_num(Integer.parseInt(ajaxData[i]));
			service.chkDel(itemVO);
		}
		rttr.addFlashAttribute("result", "deleteChk success");
		return "redirect:/test/menueManage?branch_num=" + itemVO.getBranch_num() + "&category_num=" + itemVO.getCategory_num();
	}

	// 값 하나만 보내다보니 조건문에 들어갈 값은 어떻게 해결해야할까..?
	@PostMapping("/addBestMenu")
	public String addBestMenu(HttpServletRequest request, RedirectAttributes rttr, NowPage nowPage) {
		String[] ajaxData = request.getParameterValues("checkedbtn");
		int nowCate = nowPage.getNowCate();
		for (int i = 0; i < ajaxData.length; i++) {
			service.addBestMenu(ajaxData[i]);
			System.out.println(ajaxData[i]);
		}
		rttr.addFlashAttribute("result", "addBest success");
		return "redirect:/test/menueManage?cateTest=" + nowCate;
	}

}
