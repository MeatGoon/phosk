package com.teamproject.phosk.branch.qr.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.teamproject.phosk.branch.qr.service.BranchQRService;
import com.teamproject.phosk.branch.qr.vo.BranchQRVO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/branch/qr/*")
@AllArgsConstructor
public class BranchQRController {
	
	private BranchQRService service;
	
	@GetMapping("/index")
	public void qrIndex(BranchQRVO qvo , Model model) {
		log.info("qrIndex 호출");
		log.info(qvo.getBranch_num());
		List<BranchQRVO> qrList = service.branchSelectQRinfo(qvo.getBranch_num());
		String[] qrTableNumArr = new String[qrList.size()];
		for (int i = 0; i < qrTableNumArr.length; i++) {
			qrTableNumArr[i] = qrList.get(i).getQrTable_num()+"";
		}
		model.addAttribute("qrInfo" , qvo);
		model.addAttribute("qrTableNumArr" ,Arrays.deepToString(qrTableNumArr));
		model.addAttribute("qrList" , qrList);
	}
	
	@GetMapping("/detail")
	public void qrDetail(BranchQRVO qvo, Model model) {
		log.info("qrDetail 호출");
		model.addAttribute("qrDetail", service.branchSelectOneQRinfo(qvo));
	}
	
	@RequestMapping(method = {RequestMethod.PUT, RequestMethod.PATCH},
			value = "/checkTableNum",
			consumes = "application/json",
			produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> checkTableNum(@RequestBody BranchQRVO qvo){
		log.info("qvo : "+qvo);
		return service.branchSelectOneQRinfo(qvo) == null 
				? new ResponseEntity<String>("success",HttpStatus.OK) 
				: new ResponseEntity<String>("fail" , HttpStatus.OK);
	}
	
	@PostMapping("/modify")
	public String modify(BranchQRVO qvo, RedirectAttributes rttr) {
		log.info("qrModify : " + qvo);
		if(service.branchModifyQRInfo(qvo)) {
			rttr.addFlashAttribute("result" , "success");
		}
		return "redirect:/branch/qr/index?branch_num=" + qvo.getBranch_num();
	}
	
	@PostMapping("/remove")
	public String remove(BranchQRVO qvo, RedirectAttributes rttr) {
		log.info("qrRemove : " + qvo.getQrTable_index());
		if(service.branchRemoveQRInfo(qvo.getQrTable_index())) {
			rttr.addFlashAttribute("result" , "success");
			rttr.addFlashAttribute("executions" , "삭제");
		}else {
			rttr.addFlashAttribute("result" , "fail");
		}
		return "redirect:/branch/qr/index?branch_num=" + qvo.getBranch_num();
	}
	
	@GetMapping("/register")
	public void register(BranchQRVO qvo, Model model) {
		log.info("qrRegister 호출");
		model.addAttribute("branchNum", qvo.getBranch_num());
	}
	
	@PostMapping("/register")
	public String register(BranchQRVO qvo, RedirectAttributes rttr) {
		log.info("qrregister : " + qvo);
		if(service.branchResisterQRInfo(qvo)) {
			rttr.addFlashAttribute("result" , "success");
			rttr.addFlashAttribute("executions" , "등록");
		}else {
			rttr.addFlashAttribute("result" , "fail");
		}
		return "redirect:/branch/qr/index?branch_num=" + qvo.getBranch_num();
	}
}
