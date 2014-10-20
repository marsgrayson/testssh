package com.grayson.util.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;


@SuppressWarnings("deprecation")
public class AOPTest extends AbstractDependencyInjectionSpringContextTests {
	@Autowired
	private AService aService;
	@Autowired
	private BServiceImpl bService;

	protected String[] getConfigLocations() {
		String[] configs = new String[] { "/WEB-INF/spring-conf/spring-*.xml" };
		return configs;
	}

	/**
	 * 测试正常调用
	 */
	public void testCall() {
		System.out.println("SpringTest JUnit test");
		aService.fooA("JUnit test fooA");
		aService.barA();
		bService.fooB();
		bService.barB("JUnit test barB", 0);
	}

	/**
	 * 测试After-Throwing
	 */
	public void testThrow() {
		try {
			bService.barB("JUnit call barB", 1);
		} catch (IllegalArgumentException e) {

		}
	}

	public void setAService(AService service) {
		aService = service;
	}

	public void setBService(BServiceImpl service) {
		bService = service;
	}
}
