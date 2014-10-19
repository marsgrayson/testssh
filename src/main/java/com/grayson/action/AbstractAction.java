package com.grayson.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.grayson.service.factory.ServiceFactory;
import com.opensymphony.xwork2.ActionSupport;


public abstract class AbstractAction extends ActionSupport {
		
	public final static Logger logger = LoggerFactory.getLogger(AbstractAction.class);
	private static final long serialVersionUID = 1109148210806933271L;
	@Autowired
    protected ServiceFactory serviceFactory;

	public ServiceFactory getServiceFactory() {
		return serviceFactory;
	}

	public void setServiceFactory(ServiceFactory serviceFactory) {
		this.serviceFactory = serviceFactory;
	}  
}
