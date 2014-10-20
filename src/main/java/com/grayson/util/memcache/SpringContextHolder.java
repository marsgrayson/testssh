package com.grayson.util.memcache;

import java.util.Map;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 
 * �Ծ�̬��������Spring ApplicationContext, �����κδ����κεط��κ�ʱ����ȡ��ApplicaitonContext.
 **/

public class SpringContextHolder implements ApplicationContextAware {
	private static ApplicationContext applicationContext;
	/**
	 * 
	 * ʵ��ApplicationContextAware�ӿڵ�contextע�뺯��, ������뾲̬����.
	 */
	public void setApplicationContext(ApplicationContext applicationContext) {
		SpringContextHolder.applicationContext = applicationContext;
	}

	/**
	 * 
	 * ȡ�ô洢�ھ�̬�����е�ApplicationContext.
	 */

	public static ApplicationContext getApplicationContext() {
		checkApplicationContext();
		return applicationContext;
	}

	/**
	 * 
	 * �Ӿ�̬����ApplicationContext��ȡ��Bean, �Զ�ת��Ϊ����ֵ���������.
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name) {
		checkApplicationContext();
		return (T) applicationContext.getBean(name);
	}

	/**
	 * 
	 * �Ӿ�̬����ApplicationContext��ȡ��Bean, �Զ�ת��Ϊ����ֵ���������.
	 * 
	 * ����ж��Bean����Class, ȡ����һ��.
	 */

	@SuppressWarnings("unchecked")
	public static <T> T getBean(Class<T> clazz) {
		checkApplicationContext();
		Map beanMaps = applicationContext.getBeansOfType(clazz);
		if (beanMaps != null && !beanMaps.isEmpty()) {
			return (T) beanMaps.values().iterator().next();
		} else {
			return null;
		}
	}

	private static void checkApplicationContext() {
		if (applicationContext == null) {
			throw new IllegalStateException("applicaitonContextδע��,����applicationContext.xml�ж���SpringContextHolder");
		}
	}
}