package com.teamproject.phosk.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.teamproject.phosk.user.service.CardinfoService;
import com.teamproject.phosk.user.vo.CardinfoVO;

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
			return "redirect:/userForm/usertest";
			
		}	
		 @GetMapping("/userForm/user/register")
	      public void carlist(Model model) {          
	          log.info("카드정보조회");
	          List<CardinfoVO> cardinfoForm = cardinfoservice.cardinfoForm();
	          model.addAttribute("cardinfoForm", cardinfoForm);

	      }
		 @GetMapping("/userForm/user/updateuser")
	      public void mycarlist(Model model) {          
	          log.info("회원정보");
	          List<CardinfoVO> cardinfoForm = cardinfoservice.cardinfoForm();
	          model.addAttribute("mycard", cardinfoForm);

	      }
		 //카드정보 삭제
		 @GetMapping("/writecard")
		 public void writecard() {
			 log.info("카드정보삭제");
		 }
}
