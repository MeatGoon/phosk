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
@RequestMapping("/item/*")
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

	@GetMapping("/cateList")
	public void cateList(String branch_num, BranchItemInfo itemInfo, Model model, HttpServletRequest request, NowPage nowPage) {
		log.info("cate List .....");
		List<CategoryVO> cateList = service.cateList(branch_num);
		model.addAttribute("branchInfo", branch_num);
		model.addAttribute("cateTest", service.getMenue(itemInfo));
		model.addAttribute("cateList", cateList);
	}

	@GetMapping("/menueManage") /* 카테고리 숫자 받아서 반환할거 필요할거같음 */
	public void menueManage(String  branch_num, BranchItemInfo itemInfo, Model model, HttpServletRequest request) {
		log.info("menuManage List .....");
		String cateTest = request.getParameter("cateTest");
		List<CategoryVO> cateList = service.cateList(branch_num);
		model.addAttribute("cateList", cateList);
		model.addAttribute("cateTest", service.menuGetAll(itemInfo));
		
		/* 필요한부분 */
		/* cateList = 카테고리 리스트 */
		/* cateTest = 카테고리 정보가 담긴 메뉴리스트 */
	}

	@GetMapping("/detailInfo")
	public void detailInfo(String menue_name, Model model) {
		model.addAttribute("meList", service.detailInfo(menue_name));
		/* 필요한부분 */
		/* meList = 메뉴 하나의 정보가 담겨있는 부분 */
	}

	@PostMapping("/modify")
	public String menueModify(ItemVO menueVO, RedirectAttributes rttr, NowPage nowPage) {
		service.modify(menueVO);
		int nowCate = nowPage.getNowCate();
		rttr.addFlashAttribute("result", "modify success");
		return "redirect:/test/menueManage" + nowCate;
	}

	@PostMapping("/delete")
	public String menueDelete(ItemVO menueVO, RedirectAttributes rttr, NowPage nowPage) {
		service.delete(menueVO);
		int nowCate = nowPage.getNowCate();
		rttr.addFlashAttribute("result", "delete success");
		return "redirect:/test/menueManage" + nowCate;
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

	@PostMapping("/insertMenue")
	public String insertMenue(ItemVO menueVO, int cateTest, RedirectAttributes rttr, NowPage nowPage) {
		service.insert(menueVO);
		rttr.addFlashAttribute("result", "insert success");
		return "redirect:/test/menueManage?cateTest=" + cateTest;
	}

	@PostMapping("/insrtCategory")
	public String insrtCategory(CategoryVO categoryVO, int nowCate, RedirectAttributes rttr, NowPage nowPage) {
		service.insrtCategory(categoryVO);
		return "redirect:/test/menueManage?cateTest=" + nowCate;
	}

	@PostMapping("/updateCateName")
	public String updateCateName(int category_num, CategoryVO cateVO, RedirectAttributes rttr) {
		service.updateCateName(cateVO);
		rttr.addFlashAttribute("result", "UpCateName success");
		return "redirect:/test/menueManage?cateTest=" + category_num;
	}

	@PostMapping("/deleteCategory")
	public String deleteCategory(CategoryVO cateVO, RedirectAttributes rttr) {
		service.deleteCategory(cateVO);
		rttr.addFlashAttribute("result", "delCate success");
		return "redirect:/test/menueManage";
	}

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

	@PostMapping("/deleteChk")
	public String menueDelete(HttpServletRequest request, RedirectAttributes rttr, NowPage nowPage) {
		String[] ajaxData = request.getParameterValues("checkedbtn");
		int nowCate = nowPage.getNowCate();
		for (int i = 0; i < ajaxData.length; i++) {
			service.chkDel(ajaxData[i]);
		}
		rttr.addFlashAttribute("result", "deleteChk success");
		return "redirect:/test/menueManage?cateTest=" + nowCate;
	}

	@PostMapping("/addBestMenu")
	public String addBestMenu(HttpServletRequest request, RedirectAttributes rttr, NowPage nowPage) {
		String[] ajaxData = request.getParameterValues("checkedbtn");
		int nowCate = nowPage.getNowCate();
		for (int i = 0; i < ajaxData.length; i++) {
			service.addBestMenu(ajaxData[i]);
			System.out.println(ajaxData[i]);
		}
		rttr.addFlashAttribute("result", "deleteChk success");
		return "redirect:/test/menueManage?cateTest=" + nowCate;
	}

}
