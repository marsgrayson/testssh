package com.grayson.util.threadpool.other;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.grayson.service.factory.ServiceFactory;
import com.grayson.vo.User;

public class PrintTask implements Runnable {
	public final static Logger logger = LoggerFactory
			.getLogger(PrintTask.class);
	String name;
	User vo;
    ServiceFactory serviceFactory;
	
	public PrintTask(String name,User vo,ServiceFactory serviceFactoryforthread) {
		this.name = name;
		this.vo = vo;
		serviceFactory=serviceFactoryforthread;
	}

	@Override
	public void run() {
		logger.info("{}{}{}", "我们", "在测试", Thread.currentThread().getName());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		serviceFactory.getUserService().updateAndAddVO(vo);
		logger.info("{}{}{}", "我们", "在测试", "-------------------------------------结束-----------------------");

	}
}
