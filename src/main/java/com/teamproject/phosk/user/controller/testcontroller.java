package com.teamproject.phosk.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/*")
@Controller

public class testcontroller {
	
	@GetMapping("/userForm/userQNA")
	public void qnaGET(){
		log.info("qna 페이지");
	}
	@GetMapping("/userForm/usertest")
	public void testhome(){
		log.info("testhome 페이지");
	}
	@GetMapping("/userForm/userOrder/test1")
	public void testpage(){
		log.info("가게입장 페이지");
	}
	@GetMapping("/userForm/dumibranch")
	public void dumibranch(){
		log.info("가게선택 페이지");
	}


}
