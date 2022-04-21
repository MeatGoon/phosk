package com.teamproject.phosk.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.teamproject.phosk.branch.login.dao.BranchLoginDAO;
import com.teamproject.phosk.branch.login.vo.BranchLoginVO;
import com.teamproject.phosk.branch.qr.dao.BranchQRDAO;
import com.teamproject.phosk.branch.qr.vo.BranchQRVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Log4j
public class BranchQRDaoTests {
	@Setter(onMethod_ = @Autowired )
	private  BranchQRDAO dao;
	
	@Test
	public void testGetList() {
		log.info(dao.branchSelectQRinfo("123-45-67890"));
	}
	@Test
	public void testGetOne() {
		BranchQRVO qvo = new BranchQRVO();
		qvo.setBranch_num("123-45-67890");
		qvo.setQrTable_num(1);
		log.info(dao.branchSelectOneQRinfo(qvo));
	}
	@Test
	public void testRemove() {
		log.info(dao.branchRemoveQRInfo(3));
	}
	
}
