package com.teamproject.phosk.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.teamproject.phosk.user.service.MemberService;
import com.teamproject.phosk.user.vo.MemberVO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/*")
@AllArgsConstructor
public class MemberController {
	
	@Autowired
	private MemberService memberservice;
	
	@PostMapping("/userForm/user/register")
	public String loginpagePOST(MemberVO membervo) {
		log.info("회원가입 post");
		memberservice.insertMember(membervo);
		return "/userForm/user/loginpage";
		
	} 


	@GetMapping("/userForm/user/loginpage")
	public void loginpageGET(){
		log.info("로그인 페이지");
	}
	@PostMapping("/userForm/user/loginpage")
	public String login(MemberVO membervo,HttpServletRequest req, RedirectAttributes rttr) {
		log.info("로그인 post");
		
		HttpSession session = req.getSession();
		MemberVO login = memberservice.login(membervo);
		
		if(login != null) {
			session.setAttribute("login", login);
			log.info("성공");
		}else {

			log.info("실패");
			return "redirect:/userForm/user/loginpage";
		}		
		return "/userForm/usertest";		
	}
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		log.info("로그아웃");
		
		HttpSession session = request.getSession();
		session.invalidate();
				
		return "/userForm/usertest";
	}
	
	 @GetMapping("/userForm/user/userlist")
     public void registerlist(Model model) {          
         log.info("회원정보조회");
         List<MemberVO> register = memberservice.register();
         model.addAttribute("register", register);

     }		
		@PostMapping("/userForm/user/updateuser")
		public String updatemember(MemberVO membervo, HttpSession session) { 
		log.info("회원정보수정");
		memberservice.updatemember(membervo);

		return "redirect:/userForm/usertest";
		}
		 
		@ResponseBody
		@PostMapping("/idchk")
		public void idchk(MemberVO membervo) {
			log.info("id 중복체크");

		}   
}
