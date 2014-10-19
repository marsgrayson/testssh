package com.grayson.util.jms;

import javax.jms.Destination;  

import org.junit.Test;  
import org.junit.runner.RunWith;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.beans.factory.annotation.Qualifier;  
import org.springframework.test.context.ContextConfiguration;  
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;  

import com.grayson.service.IProducerService;
   
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration("classpath:/WEB-INF/spring-conf/spring-*.xml")  
public class ProducerConsumerTest {  
   
    @Autowired  
    private IProducerService producerService;  
    @Autowired  
    @Qualifier("queueDestination")  
    private Destination destination;  
      
    @Test  
    public void testSend() {  
            producerService.sendMessage(destination, "你好，JUNIT生产者！这是消息：" + (1));  
    }  
      
}  
