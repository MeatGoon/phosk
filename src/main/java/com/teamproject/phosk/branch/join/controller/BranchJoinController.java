package com.teamproject.phosk.branch.join.controller;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.teamproject.phosk.branch.join.service.BranchJoinService;
import com.teamproject.phosk.branch.login.vo.BranchLoginVO;
import com.teamproject.phosk.branch.qr.vo.BranchQRVO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/branch/join/*")
@AllArgsConstructor
public class BranchJoinController {
	
	private BranchJoinService service;
	
	@GetMapping("/index")
	public void branchJoginIndex() {
		log.info("branchJoginIndex 호출");
	}
	
	@PostMapping(value = "/idOrEmailCheck", consumes = "application/json")
	public ResponseEntity<String> check(@RequestBody BranchLoginVO bvo){
		log.info("check: " + bvo);
		return service.branchCheckIDForEmail(bvo) == null 
				?  new ResponseEntity<String>("success", HttpStatus.OK)
				:  new ResponseEntity<String>("false", HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public String branchOnerRegister(BranchLoginVO bvo, RedirectAttributes rttr) {
		log.info("branchOnerRegister : " + bvo);
		if(service.branchOnerRegister(bvo)) {
			rttr.addFlashAttribute("result" , "success");
		}else {
			rttr.addFlashAttribute("result" , "fail");
		}
		rttr.addFlashAttribute("executions" , "등록");
		return "redirect:/branch/login/index";
	}
}
