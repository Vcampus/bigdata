package cn.edu.seu.bigdata.service.impl;

import cn.edu.seu.bigdata.bean.Location;
import cn.edu.seu.bigdata.service.LocationService;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class LocationServiceImplTest extends AbstractJUnit4SpringContextTests {
	
	@Resource
	 LocationService locationService;
	
	@Test
	public void  qryLocationByLatAndLng(){
		locationService.qryLocationByLatAndLng(111.2323225, 125.1111111);
	}
	

	
	

}
