package com.teamproject.phosk.option.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.teamproject.phosk.option.service.BasicoptionService;
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
	public void menuEditPopup() {
		log.info("메뉴등록페이지");
	}
	@PostMapping("/menueditpopup/menuEditPopup")
	public String menuupdatePOST(BasicOptionVO basicoptionvo, AddOptionVO addoptionvo){
		log.info("옵션 post");
		log.info("BasicOptionVO : " + basicoptionvo);
		log.info("AddOptionVO : " + addoptionvo);
		
		basicoptionservice.insertBasicoption(basicoptionvo);
		addoptionservice.insertAddoption(addoptionvo);
		return "redirect:/jundemo/menueditpopup/menuEditPopup";
	}

}




