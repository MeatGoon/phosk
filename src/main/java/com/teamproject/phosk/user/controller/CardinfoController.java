package com.teamproject.phosk.user.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
			
			
		// 카드삭제 post
		 @GetMapping("/writecard")
		 public String writecard(HttpSession session, CardinfoVO cardinfovo, RedirectAttributes rttr){
		  log.info("post delete");		  		  		      
		  
		  
		  CardinfoVO card = (CardinfoVO)session.getAttribute("card");
		  
		  String oldPass = card.getCardinfo_cardNum();
		  String newPass = cardinfovo.getCardinfo_cardNum();
		      
		  if(!(oldPass.equals(newPass))) {
		   rttr.addFlashAttribute("msg", false);
		   return "/userForm/user/updateuser";
		  }
		  
		  cardinfoservice.writecard(cardinfovo);
		  
		  session.invalidate();
		   
		  return "/userForm/user/updateuser";
		 }
}
