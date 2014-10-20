package com.grayson.util.redis;

import static org.junit.Assert.assertEquals;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.grayson.vo.*;

public class UserDaoTest {
	private ApplicationContext app;
	private UserDao userDao;
	@Before
	public void before() throws Exception {
		app = new ClassPathXmlApplicationContext("classpath:/WEB-INF/spring-conf/spring-*.xml");
		userDao = (UserDao) app.getBean("userDao");
	}
	@Test
	public void crud() {
		// -------------- Create ---------------
		String userName = "grayson";
		String passWd = "graysonpwd";
		User user = new User();
		user.setUserName(userName);
		user.setPassWd(passWd);
		userDao.save(user);
		// ---------------Read ---------------
		user = userDao.read(userName);
		System.out.println("passWd="+user.getPassWd());
		assertEquals(passWd, user.getPassWd());
		// --------------Update ------------
		passWd = "±±¾©";
		user.setPassWd(passWd);
		userDao.save(user);
		user = userDao.read(userName);
		System.out.println("address2Save="+user.getPassWd());
		assertEquals(passWd, user.getPassWd());
		// --------------Delete ------------
//		userDao.delete(userName);
//		user = userDao.read(userName);
//		assertNull(user);
//		System.out.println("user="+user);
	}
}
