package com.grayson.util.memcache;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.danga.MemCached.MemCachedClient;

public class MemcacheUtilTest {
	private ApplicationContext app;
	private  MemCachedClient memcachedClient;
	@Before
	public void before() throws Exception {
		app = new ClassPathXmlApplicationContext("classpath:/WEB-INF/spring-conf/spring-*.xml");
		memcachedClient = (MemCachedClient) app.getBean("memcachedClient");
	}
    @Test
    public void test() {
    	memcachedClient.set("name", "grayson");
        System.out.println(memcachedClient.get("name"));
    }
}
