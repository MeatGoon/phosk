package com.teamproject.phosk.user.login.contorller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.teamproject.phosk.user.service.MemberService;
import com.teamproject.phosk.user.vo.MemberVO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/user/login/*")
@AllArgsConstructor
public class MemberLoginController {
	private MemberService mservice;
	
	@GetMapping("/index")
	public String memberLoginIndex() {
		log.info("memberLoginIndex 호출");
		return "/user/index";
	}
	
	@PostMapping("/result")
	public void memberLoginResult(MemberVO mvo) {
		log.info("memberLoginResult 호출");
		log.info("확인바람" + mvo.getMember_id() + mvo.getMember_pwd());
		
		
	}
	
}
