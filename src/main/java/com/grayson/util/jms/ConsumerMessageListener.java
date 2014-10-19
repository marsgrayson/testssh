package com.grayson.util.jms;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.jms.JMSException;  
import javax.jms.Message;  
import javax.jms.MessageListener;  
import javax.jms.TextMessage;  

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.grayson.util.threadpool.other.PrintTask;

   
public class ConsumerMessageListener implements MessageListener { 
	public final static Logger logger = LoggerFactory.getLogger(ConsumerMessageListener.class);
	Lock lock = new ReentrantLock();
	@Autowired
	private  ThreadPoolTaskExecutor taskExecutor;
    public void onMessage(Message message) {  
        //��������֪�������߷��͵ľ���һ�����ı���Ϣ�������������ֱ�ӽ���ǿ��ת��  
        TextMessage textMsg = (TextMessage) message;  
        logger.info("���յ�һ�����ı���Ϣ��");  
        taskExecutor.execute(new PrintTask("Thread 1"));
 		taskExecutor.execute(new PrintTask("Thread 2"));
 		taskExecutor.execute(new PrintTask("Thread 3"));
 		taskExecutor.execute(new PrintTask("Thread 4"));
 		taskExecutor.execute(new PrintTask("Thread 5"));
 		while(true) {
 			lock.lock();
 			int count = taskExecutor.getActiveCount();
 			logger.info("Active Threads : " + count);
 			try {  
 				logger.info("��Ϣ�����ǣ�" + textMsg.getText());  
 			} catch (JMSException e) {  
 				e.printStackTrace();  
 			}  
 			lock.unlock();
 			try {
 				Thread.sleep(1000);
 			} catch (InterruptedException e) {
 				e.printStackTrace();
 			}
 			if (count == 0) {
 				// ������̣߳������߳���Ϊ0��ر��̳߳�
 				// taskExecutor.shutdown();
 				break;
 			}
 		}
    }  
   
}  