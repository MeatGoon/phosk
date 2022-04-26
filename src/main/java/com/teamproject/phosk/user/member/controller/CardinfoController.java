package com.teamproject.phosk.user.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.teamproject.phosk.user.member.service.CardinfoService;
import com.teamproject.phosk.user.member.vo.CardinfoVO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/*")
@AllArgsConstructor
public class CardinfoController {
	
	@Autowired
	private CardinfoService cardinfoservice;
	
	//카드 입력창 띄우기
		@GetMapping("/userForm/cardinfo/cardinfoForm")
		public void cardinfoGET(){
			log.info("카드정보등록 페이지");
		}
		@PostMapping("/userForm/cardinfo/cardinfoForm")
		public String cardinfoPOST(CardinfoVO cardinfovo) {
			log.info("카드정보 post");
			cardinfoservice.insertCard(cardinfovo);
			return "redirect:/userForm/user/updateuser";
			
		}	

		 @GetMapping("/userForm/user/updateuser")
	      public void mycarlist(Model model) {          
	          log.info("회원정보");
	          List<CardinfoVO> cardinfoForm = cardinfoservice.cardinfoForm();
	          model.addAttribute("mycard", cardinfoForm);

	      }
			
			
		// 카드삭제 post
		 @PostMapping("/delete/carddel")
		 public String carddel(String cardinfo_cardNum){
		  log.info("post delete");		  		  		      	  
		  cardinfoservice.carddel(cardinfo_cardNum);
		  
		 	   
		  return "redirect:/userForm/user/updateuser";
		 }
		 //카드전체삭제
		 @PostMapping("/delete/cardall")
		 public String cardall(String member_id){
		  log.info("post delete all");		  		  		      	  
		  cardinfoservice.cardall(member_id);
		  return "redirect:/userForm/user/updateuser";
		 }
}
