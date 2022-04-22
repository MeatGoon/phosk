package com.teamproject.phosk.branch.menu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.OpInc;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.teamproject.phosk.branch.menu.service.ItemService;
import com.teamproject.phosk.branch.menu.vo.BranchItemInfo;
import com.teamproject.phosk.branch.menu.vo.CategoryVO;
import com.teamproject.phosk.branch.menu.vo.ItemOptionVO;
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

	// 메뉴 관리 메인 페이지
	@GetMapping("/cateList")
	public void cateList(BranchItemInfo itemInfo, Model model, HttpServletRequest request, NowPage nowPage) {
		log.info("cate List .....");
		String branch_num = itemInfo.getBranch_num();
		model.addAttribute("branchInfo", branch_num); // 사업자 번호만 반환
		model.addAttribute("cateNum", itemInfo.getCategory_num()); // 현재 카테고리 위치 반환
		model.addAttribute("cateTest", service.getMenue(itemInfo));
		model.addAttribute("itemPrice", service.getItemPrice(itemInfo));
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
		model.addAttribute("cateTest", service.getMenue(itemInfo));
		model.addAttribute("itemPrice", service.getItemPrice(itemInfo));
		model.addAttribute("cateList", service.cateList(branch_num));
	}

	// 메뉴 상세정보
	@GetMapping("/detailInfo")
	public void detailInfo(BranchItemInfo itemInfo, Model model) {
		model.addAttribute("cateTest", service.menuDetail(itemInfo));
		model.addAttribute("bOptions", service.getBOption(itemInfo));
		model.addAttribute("aOptions", service.getAOption(itemInfo));
	}
	
	// 메뉴 수정 페이지 이동
	@GetMapping("/itemModify")
	public void itemModify(BranchItemInfo itemInfo, Model model) {
		model.addAttribute("cateTest", service.menuDetail(itemInfo));
		model.addAttribute("bOptions", service.getBOption(itemInfo));
		model.addAttribute("aOptions", service.getAOption(itemInfo));
	}

	// 메뉴 수정
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

	@PostMapping("/insrtCategory")
	public String insrtCategory(CategoryVO cateVo, RedirectAttributes rttr) {
		System.out.println(cateVo);
		service.insrtCategory(cateVo);
		return "redirect:/test/menueManage?branch_num=" + cateVo.getBranch_num() + "&category_num=" + cateVo.getCategory_num();
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
		return "redirect:/test/menueManage?branch_num=" + itemInfo.getBranch_num();
	}
	
	// 아이템 삭제
	@PostMapping("/deleteItem")
	public String menueDelete(BranchItemInfo itemInfo, RedirectAttributes rttr) {
		service.deleteItem(itemInfo);
		rttr.addFlashAttribute("result", "delete success"); // delete success 메인페이지로 반환 됨
		return "redirect:/test/cateList?branch_num=" + itemInfo.getBranch_num() + "&category_num=" + itemInfo.getCategory_num();
	}
	
	@PostMapping("/deleteBOption")
	public String deleteBOption(ItemOptionVO optionInfo, HttpServletRequest request, RedirectAttributes rttr) {
		String branchNum = request.getParameter("branchNum");
		int cateNum = Integer.parseInt(request.getParameter("cateNum"));
		int itmeNum = Integer.parseInt(request.getParameter("itmeNum"));
		String optionName = request.getParameter("optionName");

		optionInfo.setBranch_num(branchNum);
		optionInfo.setItem_num(itmeNum);
		optionInfo.setBasic_option(optionName);

		service.deleteBOption(optionInfo);
		
		rttr.addFlashAttribute("result", "delete success"); // delete success 메인페이지로 반환 됨
		return "redirect:/test/cateList?branch_num=" + branchNum + "&category_num=" + cateNum + "&item_num=" + itmeNum;
	}
	
	@PostMapping("/deleteAOption")
	public String deleteAOption(ItemOptionVO optionInfo, HttpServletRequest request, RedirectAttributes rttr) {
		String branchNum = request.getParameter("branchNum");
		int cateNum = Integer.parseInt(request.getParameter("cateNum"));
		int itmeNum = Integer.parseInt(request.getParameter("itmeNum"));
		String optionName = request.getParameter("optionName");

		optionInfo.setBranch_num(branchNum);
		optionInfo.setItem_num(itmeNum);
		optionInfo.setAdd_option(optionName);

		service.deleteAOption(optionInfo);
		
		rttr.addFlashAttribute("result", "delete success"); // delete success 메인페이지로 반환 됨
		return "redirect:/test/cateList?branch_num=" + branchNum + "&category_num=" + cateNum + "&item_num=" + itmeNum;
	}

	// 메뉴 선택 삭제
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

	// 인기메뉴 등록
	@PostMapping("/addBestMenu")
	public String addBestMenu(ItemVO itemVO, HttpServletRequest request, RedirectAttributes rttr) {
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
			service.addBestMenu(itemVO);
		}
		rttr.addFlashAttribute("result", "bestMenu success");
		return "redirect:/test/menueManage?branch_num=" + itemVO.getBranch_num() + "&category_num=" + itemVO.getCategory_num();
	}
	
	// 인기메뉴 해제
	@PostMapping("/deleteBestMenu")
	public String deleteBestMenu(ItemVO itemVO, HttpServletRequest request, RedirectAttributes rttr) {
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
			service.deleteBestMenu(itemVO);
		}
		rttr.addFlashAttribute("result", "deleteBestMenu success");
		return "redirect:/test/menueManage?branch_num=" + itemVO.getBranch_num() + "&category_num=" + itemVO.getCategory_num();
	}

}
