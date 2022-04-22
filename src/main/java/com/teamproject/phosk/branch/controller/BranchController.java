package com.teamproject.phosk.branch.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/branch/main/*")
@AllArgsConstructor
public class BranchController {
	
	/*
	 * @GetMapping("/index") public void branchMainIndex(@RequestParam("branch_num")
	 * String branch_num , Model model) { log.info("branchMainIndex 호출");
	 * log.info(branch_num); model.addAttribute("branch_num" , branch_num); }
	 */
	@GetMapping
	public void branchmain(Model model) {
		log.info("지점메인");
	}
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		log.info("로그아웃");
		
		HttpSession session = request.getSession();
		session.invalidate();
				
		return "redirect:/branch/main/index";
	}
}
