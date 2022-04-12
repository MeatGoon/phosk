package com.teamproject.phosk.junoptiondemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.log4j.Log4j;


@Controller
@RequestMapping(value="/jundemo/*")
@Log4j
public class OnerTestController {
	@RequestMapping("")
	public void jundemo() {	
		log.info("jundemo.....");
	}
	
	
	@RequestMapping(value = "/menueditpopup/*")
	public void menueditpopup() {
		log.info("menueditpopup.....");
	}
	
	/*
	  @PostMapping("/qr" ) public String qrcode(@RequestParam String content) {
	  QRCodeView qr = new QRCodeView();
	  
	  
	  return "redirect:/jundemo/qrtest"; }
	 */
			  
	@RequestMapping(value = "/tablesetting/*")
	public void tablesetting() {
		log.info("tablesetting.....");
	}			  



	}	












/*	@RequestMapping(value = "/onerHeader")
	public String onerHeader(){
		return "test/onerHeader";
	}
	
	@RequestMapping(value = "/menueditpopup/menuEditPopup")
	public String menuEditPopup() {
		return "test/menueditpopup/menuEditPopup";
	}
	
	
	@RequestMapping(value = "/menueditpopup/menuEditOptionPopup")
	public String menuEditOptionPopup() {
		return "test/menueditpopup/menuEditOptionPopup";
	}
	
}*/






