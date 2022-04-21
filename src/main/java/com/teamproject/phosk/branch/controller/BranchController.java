package com.teamproject.phosk.branch.controller;

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
	
	@GetMapping("/index")
	public void branchMainIndex(@RequestParam("branch_num") String branch_num , Model model) {
		log.info("branchMainIndex 호출");
		log.info(branch_num);
		model.addAttribute("branch_num" , branch_num);
	}
}
