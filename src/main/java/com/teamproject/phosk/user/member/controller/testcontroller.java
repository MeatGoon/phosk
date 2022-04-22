package com.teamproject.phosk.user.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.teamproject.phosk.branch.info.vo.BranchInfoVO;
import com.teamproject.phosk.user.main.service.UsermainService;

import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/*")
@Controller

public class testcontroller {
	
	@Autowired
	private UsermainService usermainservice;
	
	
	
	 
	 


}
