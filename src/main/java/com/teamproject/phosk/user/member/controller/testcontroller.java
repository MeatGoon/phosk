package com.teamproject.phosk.user.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.teamproject.phosk.branch.info.vo.BranchInfoVO;
import com.teamproject.phosk.user.main.service.UsermainService;

import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/*")
@Controller

public class testcontroller {
	
	@Autowired
	private UsermainService usermainservice;
	
	@GetMapping("/userForm/userQNA")
	public void qnaGET(@RequestParam("member_id") String member_id , Model model){
		log.info("qna 페이지");
		model.addAttribute("member_id" , member_id);
		
	}
	@GetMapping("/userForm/usertest")
	public void testhome(){
		log.info("testhome 페이지");
		
	}
	 @GetMapping("/user/usermain")
     public void usermain(Model model) {          
         log.info("메인페이지 조회");
         List<BranchInfoVO> branchlist = usermainservice.branchlist();
         model.addAttribute("branchlist", branchlist);

     }	
	 
	 


}
