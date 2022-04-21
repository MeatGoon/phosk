package com.teamproject.phosk.user.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.teamproject.phosk.branch.info.vo.BranchInfoVO;
import com.teamproject.phosk.user.main.paging.Criteria;
import com.teamproject.phosk.user.main.paging.pageMaker;
import com.teamproject.phosk.user.main.service.UsermainService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/*")
@AllArgsConstructor
public class UsermainController {
	@Autowired
	private UsermainService usermainservice;
	

	
	 @GetMapping("/user/usermain")
     public void usermain(Model model) {          
         log.info("메인페이지 조회");
         List<BranchInfoVO> branchlist = usermainservice.branchlist();
         model.addAttribute("branchlist", branchlist);

     }	
	 
	 @GetMapping("/user/branchpaging")
	 public void branchpaging(Criteria cri,Model model) {
		 log.info("페이징");
		 
		 List<BranchInfoVO> list = usermainservice.branchpaging(cri);
		 
		 model.addAttribute("list",list);
		 
		 pageMaker pagemaker = new pageMaker();
		 pagemaker.setCri(cri);
		 pagemaker.setTotalCount(usermainservice.listcount());
		 model.addAttribute("pagemaker",pagemaker);
	 }
	

}
