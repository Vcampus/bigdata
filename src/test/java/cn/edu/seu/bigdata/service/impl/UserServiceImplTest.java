package cn.edu.seu.bigdata.service.impl;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.edu.seu.bigdata.bean.User;
import cn.edu.seu.bigdata.exception.LoginException;
import cn.edu.seu.bigdata.exception.RegisterException;
import cn.edu.seu.bigdata.service.UserManageService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserServiceImplTest extends AbstractJUnit4SpringContextTests{



	@Resource
	private UserManageService userService;
	
	@Resource
	private UserManageService userServiceCommon;
	
	
	@Test
	public void testLogin() {
		
		//IOC  inervsion of control   DI   dependency injection
		
//		UserService userService = (UserService) ctx.getBean("userService");
//		UserService userService = new UserServiceImpl();
		
		try {
			User user = userService.loginByAccoutAndPassword("zhangsan", "12345");
			assertEquals("zhangsan",user.getName());
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@Test
	public void testCommonLogin() {
		
		//IOC  inervsion of control   DI   dependency injection
		
//		UserService userService = (UserService) ctx.getBean("userService");
//		UserService userService = new UserServiceImpl();
		
		try {
			User user = userServiceCommon.loginByAccoutAndPassword("zhangsan", "11111");
			assertEquals("zhangsan",user.getName());
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	public void testRegister() {
		try {
			userService.register("qinshou", "44444", "44444");
		} catch (RegisterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test 
	public void testGetuser(){
		userService.getAllUSer();
	}

}
