package com.teamproject.phosk.user.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
	public String login(MemberVO membervo,HttpServletRequest req,HttpServletResponse response, RedirectAttributes rttr ) throws IOException {	 
		

		log.info("로그인 post");
		
		HttpSession session = req.getSession();
		MemberVO login = memberservice.login(membervo);
		
		if(login != null) {
			session.setAttribute("login", login);
			log.info("성공");
		}else {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html; charset=UTF-8");
			out.println("<script>alert('정보가 틀립니다'); </script>");
			out.flush();
			log.info("실패");			
			return "/userForm/user/loginpage";
			
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
		
		 //회원탈퇴
		 @PostMapping("/delete/userdel")
		 public String userdel(String member_id ,HttpSession session){
		  log.info("post delete all");
		  		
		  		  
		  memberservice.userdel(member_id);
		  session.invalidate();
		 
		  return "redirect:/userForm/usertest";
		 }
		 
		@ResponseBody
		@PostMapping("/idchk")
		public int idchk(HttpServletRequest req) {
			log.info("id중복체크");
			
			String member_id = req.getParameter("member_id");
			MemberVO idchk = memberservice.idchk(member_id);
				
			int result = 0;
			
			if(idchk != null) {
				result = 1;
			}
			return result;
		} 
		@ResponseBody
		@PostMapping("/nicchk")
		public int nicchk(HttpServletRequest req) {
			log.info("nic중복체크");
			
			String member_nic = req.getParameter("member_nic");
			MemberVO nicchk = memberservice.idchk(member_nic);
			
			int result = 0;
			
			if(nicchk != null) {
				result = 1;
			}
			return result;
		} 
}
