package com.grayson.service.impl;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import com.grayson.service.IProducerService;
   
@Component  
public class ProducerServiceImpl implements IProducerService {  
	public final static Logger logger = LoggerFactory.getLogger(ProducerServiceImpl.class);
	@Autowired
	private JmsTemplate jmsTemplate;  
    @Override
    public void sendMessage(Destination destination, final String message) {  
    	logger.info("---------------生产者发送消息-----------------");  
    	logger.info("---------------生产者发了一个消息：" + message);  
        jmsTemplate.send(destination, new MessageCreator() {  
            public Message createMessage(Session session) throws JMSException {  
                return session.createTextMessage(message);  
            }  
        });  
    }   
//    public JmsTemplate getJmsTemplate() {  
//        return jmsTemplate;  
//    }   
//  
//    @Resource  
//    public void setJmsTemplate(JmsTemplate jmsTemplate) {  
//        this.jmsTemplate = jmsTemplate;  
//    }  
}  
