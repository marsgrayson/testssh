package com.grayson.util.threadpool.other;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrintTask implements Runnable {
	public final static Logger logger = LoggerFactory
			.getLogger(PrintTask.class);
	String name;

	public PrintTask(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		logger.info("{}{}{}", "Œ“√«", "‘⁄≤‚ ‘", Thread.currentThread().getName());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
