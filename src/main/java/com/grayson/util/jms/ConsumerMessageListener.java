package com.grayson.util.jms;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
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

import com.danga.MemCached.MemCachedClient;
import com.grayson.service.factory.ServiceFactory;
import com.grayson.util.aop.AService;
import com.grayson.util.aop.BServiceImpl;
import com.grayson.util.redis.UserDao;
import com.grayson.util.threadpool.other.PrintTask;
import com.grayson.vo.User;

   
public class ConsumerMessageListener implements MessageListener { 
	public final static Logger logger = LoggerFactory.getLogger(ConsumerMessageListener.class);
	Lock lock = new ReentrantLock();
	@Autowired
	private  ThreadPoolTaskExecutor taskExecutor;
	@Autowired
	private ServiceFactory serviceFactory;
	@Autowired
	private AService aService;
	@Autowired
	private BServiceImpl bService;
	@Autowired
	private  MemCachedClient memcachedClient;
	@Autowired
	private UserDao userDao;
    public void onMessage(Message message) {  
        //��������֪�������߷��͵ľ���һ�����ı���Ϣ�������������ֱ�ӽ���ǿ��ת��  
        TextMessage textMsg = (TextMessage) message;  
        logger.info("���յ�һ�����ı���Ϣ��");  
        for(int i=0;i<=5000;i++){
        	 taskExecutor.execute(new PrintTask("Thread "+i,new User(),serviceFactory));
        }
//      taskExecutor.execute(new PrintTask("Thread 1",new User(),serviceFactory));
// 		taskExecutor.execute(new PrintTask("Thread 2",new User(),serviceFactory));
// 		taskExecutor.execute(new PrintTask("Thread 3",new User(),serviceFactory));
// 		taskExecutor.execute(new PrintTask("Thread 4",new User(),serviceFactory));
// 		taskExecutor.execute(new PrintTask("Thread 5",new User(),serviceFactory));
 		System.out.println("SpringTest JUnit test");
		aService.fooA("JUnit test fooA");
		aService.barA();
		bService.fooB();
		bService.barB("JUnit test barB", 0);
		memcachedClient.set("name", "grayson");
        System.out.println(memcachedClient.get("name"));
        
    	String userName = "grayson";
        String passWd = "graysonpwd";
		User user = new User();
		user.setUserName(userName);
		user.setPassWd(passWd);
		userDao.save(user);
		// ---------------Read ---------------
		user = userDao.read(userName);
		System.out.println("passWd="+user.getPassWd());
		// --------------Update ------------
		passWd = "����";
		user.setPassWd(passWd);
		userDao.save(user);
		user = userDao.read(userName);
		System.out.println("address2Save="+user.getPassWd());
        
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
 		List a= new ArrayList();
 		int b=1;
 		while(true){
 			String tt=new String("grayson__"+b);
 			System.out.println(tt);
 			a.add(tt);
 			b++;
 		}
    }  
   
}  
