package com.teamproject.phosk.user.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.teamproject.phosk.branch.info.vo.BranchInfoVO;
import com.teamproject.phosk.branch.menu.vo.CategoryVO;
import com.teamproject.phosk.branch.menu.vo.ItemVO;
import com.teamproject.phosk.branch.qr.vo.BranchQRVO;
import com.teamproject.phosk.user.main.paging.Criteria;
import com.teamproject.phosk.user.main.paging.pageMaker;
import com.teamproject.phosk.user.main.service.UsermainService;
import com.teamproject.phosk.user.main.service.UsermenuService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/*")
@AllArgsConstructor
public class UsermainController {
	@Autowired
	private UsermainService usermainservice;
	@Autowired
	private UsermenuService usermenuservice;
	
	 @GetMapping("/user/branchpaging")
	 public void branchpaging(Criteria cri,Model model) {
		 log.info("식당선택페이지");
		 
		 List<BranchInfoVO> list = usermainservice.branchpaging(cri);
		 
		 model.addAttribute("list",list);
		 
		 pageMaker pagemaker = new pageMaker();
		 pagemaker.setCri(cri);
		 pagemaker.setTotalCount(usermainservice.listcount());
		 model.addAttribute("pagemaker",pagemaker);
	 }
	 @GetMapping("/user/tablechoice")
     public void qrlist(BranchInfoVO branchvo, Model model) {  
		 
         log.info("테이블 조회");
         String branch_num = branchvo.getBranch_num();
         List<BranchQRVO> qrlist = usermainservice.qrlist();         
         model.addAttribute("qrlist", qrlist);
         model.addAttribute("branch_num" , branch_num);
        
                
     }	
	 @GetMapping("/user/usermenue")
     public void usermenue(Model model, BranchInfoVO branchvo, String qrtable_num) {          
         log.info("메인페이지 조회");
         
         String branch_num = branchvo.getBranch_num();
         
         List<CategoryVO> catemenulist = usermenuservice.catemenulist();
         List<ItemVO> itemmenulist = usermenuservice.itemmenulist();
         
         model.addAttribute("catemenulist",catemenulist);
         model.addAttribute("itemmenulist",itemmenulist);
         model.addAttribute("branch_num" , branch_num);
         model.addAttribute("qrtable_num" , qrtable_num);        
     }	

}
