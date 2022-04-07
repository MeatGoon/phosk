package com.teamproject.phosk.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/*")
@Controller

public class testcontroller {
	
	@GetMapping("/userQNA")
	public void qnaGET(){
		log.info("qna 페이지");
	}
	@GetMapping("/usertest")
	public void usertest(){
		log.info("qna 페이지");
	}
}
