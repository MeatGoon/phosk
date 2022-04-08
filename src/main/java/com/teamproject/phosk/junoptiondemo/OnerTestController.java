package com.teamproject.phosk.junoptiondemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import lombok.extern.log4j.Log4j;


@Controller
@RequestMapping(value="/test/*")
@Log4j
public class OnerTestController {
	@RequestMapping("")
	public void basic() {	
		log.info("test.....");
	}
	

	@RequestMapping(value = "/menueditpopup/*")
	public void menueditpopup() {
		log.info("menueditpopup.....");
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






