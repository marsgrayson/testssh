package com.grayson.service.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grayson.service.IProducerService;
import com.grayson.service.IUserService;

@Service("serviceFactory")
public class ServiceFactory {
	@Autowired
	private IUserService userService;
	@Autowired
	private IProducerService producerService;

	public IProducerService getProducerService() {
		return producerService;
	}

	public void setProducerService(IProducerService producerService) {
		this.producerService = producerService;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
}
