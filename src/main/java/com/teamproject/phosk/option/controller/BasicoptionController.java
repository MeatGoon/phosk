package com.teamproject.phosk.option.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.teamproject.phosk.option.service.BasicoptionService;
import com.teamproject.phosk.branch.menu.vo.BranchItemInfo;
import com.teamproject.phosk.option.service.AddoptionService;
import com.teamproject.phosk.option.vo.BasicOptionVO;
import com.teamproject.phosk.option.vo.AddOptionVO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;


@Controller
@Log4j
@RequestMapping(value="/jundemo/*")
@AllArgsConstructor
public class BasicoptionController {

	
	 @RequestMapping("") public void jundemo() {
	 log.info("jundemo....."); }
	
	 @GetMapping("/menueditpopup/menuEditOptionPopup") public void menueditpopup() {
	 log.info("menueditpopup....."); }
	 
	 
	@Autowired
	private BasicoptionService basicoptionservice;
	private AddoptionService addoptionservice;
	
	/*
	 * @RequestMapping(value = "/menueditpopup/menuEditOptionPopup") public void
	 * menueditoptionpopup() { log.info("menueditoptionpopup....."); }
	 */

	@GetMapping("/menueditpopup/menuEditPopup")
	public void cateList(BranchItemInfo itemInfo, Model model, HttpServletRequest request, HttpSession session) {
		log.info("메뉴등록페이지");
		String branch_num = itemInfo.getBranch_num();
		if(session.getAttribute("branchNumSession") != null) {
			session.removeAttribute("branchNumSession");
		}
		session.setAttribute("branchNumSession", branch_num);
		model.addAttribute("branchInfo", branch_num);
	}
	@PostMapping("/menueditpopup/savedata")
	public String basicoptionup(BasicOptionVO basicoptionvo){
		log.info("옵션 post");
		log.info("BasicOptionVO : " + basicoptionvo);

		
		basicoptionservice.insertBasicoption(basicoptionvo);
		return "redirect:/jundemo/menueditpopup/menuEditPopup";
	}

	
	@PostMapping("/menueditpopup/addsavedata")
	public String addoptionup(AddOptionVO addoptionvo){
		log.info("옵션 post");
		log.info("AddOptionVO : " + addoptionvo);

		
		addoptionservice.insertAddoption(addoptionvo);
		return "redirect:/jundemo/menueditpopup/menuEditPopup";
	}
	

	

	
}




