package com.teamproject.phosk.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.teamproject.phosk.branch.join.dao.BranchJoinDAO;
import com.teamproject.phosk.branch.login.vo.BranchLoginVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Log4j
public class BranchJoinDaoTests {
	
	@Setter(onMethod_ = @Autowired )
	private  BranchJoinDAO dao;
	
	@Test
	public void testselectOner() {
		BranchLoginVO bvo = new BranchLoginVO();
		bvo.setOner_id("testID");
		//bvo.setOner_email("testEmail@test.com");
		log.info(dao.branchCheckIDForEmail(bvo));
		if(dao.branchCheckIDForEmail(bvo) != null) {
			System.out.println("ㅁㄴㅇㅁㄴㅇㅁㅇㅁㄴㅇ");
		}
	}
}
