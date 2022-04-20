package com.teamproject.phosk.junoptiondemo;

import java.text.DateFormat;
import java.util.Locale;
import java.util.Date;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



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
	
	
	
	
	@RequestMapping(value = "/junmain")
	public void junmain() {
		log.info("junmain.....");
	}
	
	
	
			  
	@RequestMapping(value = "/tablesetting/*")
	public void tablesetting() {
		log.info("tablesetting.....");
	}	
	

	
	
	
	
	
}


		






