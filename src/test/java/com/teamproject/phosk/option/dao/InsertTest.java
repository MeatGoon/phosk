package com.teamproject.phosk.option.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.teamproject.phosk.option.vo.BasicOptionVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml" , "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Log4j
public class InsertTest {
	
	@Autowired
	BasicoptionDAO optionDao;
	
	@Test
	public void testInsert(){
		BasicOptionVO vo  = new BasicOptionVO();
		
		vo.setBranch_num("123-45-67890");
		vo.setCategory_num(2);
		vo.setItem_num(2);
		vo.setBasic_option("기본");
		vo.setBasic_price(1000);
		
		optionDao.insertbasicoption(vo);
	}
	
}
