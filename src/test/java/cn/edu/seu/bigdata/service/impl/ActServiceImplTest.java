package cn.edu.seu.bigdata.service.impl;

import static org.junit.Assert.*;
import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.edu.seu.bigdata.service.ActService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ActServiceImplTest extends AbstractJUnit4SpringContextTests {
	@Resource
	ActService actService;
	
	@Test
	public void testdeteteAct(){
		actService.deleteActByUserId(1);
	}
	
	@Test
	public void testRelate(){
		actService.relateUserToLocation(2, 3);
	}
	

}
