package com.teamproject.phosk.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.teamproject.phosk.branch.join.service.BranchJoinService;
import com.teamproject.phosk.branch.login.vo.BranchLoginVO;

import lombok.extern.log4j.Log4j;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Log4j
public class BranchJoinServiceTests {
	
	@Autowired
	private BranchJoinService service;
	
	@Test
	public void testExist() {
		log.info(service);
		assertNotNull(service);
	}
	
	@Test
	public void testChoiceBranch() {
		BranchLoginVO bvo = new BranchLoginVO();
		bvo.setOner_id("testID");
		System.out.println(bvo);
		service.branchCheckIDForEmail(bvo);
	}
	
}
