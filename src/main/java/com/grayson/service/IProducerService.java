package com.grayson.service;

import javax.jms.Destination;

public interface IProducerService {
	  public void sendMessage(Destination destination, final String message);
}
