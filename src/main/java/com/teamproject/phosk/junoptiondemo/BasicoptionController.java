package com.teamproject.phosk.junoptiondemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.teamproject.phosk.junoptiondemo.BasicoptionService;
import com.teamproject.phosk.junoptiondemo.BasicOptionVO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;


@Controller
@Log4j
@RequestMapping("/*")
@AllArgsConstructor
public class BasicoptionController {

	
	@Autowired
	private BasicoptionService basicoptionservice;

	@GetMapping("/jundemo/menuEditOptionPopup/menuEditPopup")
	public void menuupdate() {
		log.info("메뉴등록페이지");
	}
	@PostMapping("/jundemo/menuEditOptionPopup/menuEditPopup")
	public void menuupdatePOST(BasicOptionVO basicoptionvo){
		log.info("사이즈 옵션 post");
		basicoptionservice.insertBasicoption(basicoptionvo);
	}














}
