package com.grayson.action;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.grayson.util.threadpool.other.PrintTask;
import com.grayson.vo.User;

public class LoginAction extends AbstractAction {  
	
	
	@Autowired
	private  ThreadPoolTaskExecutor taskExecutor;
	private static final long serialVersionUID = 1L;
	private String username;  
    private String password;  

 // @RequestMapping("/doLogin")
     public String dologin(){  
         logger.debug(username);  
         logger.debug(password);  
         User user =new User();  
         Integer id = new Integer(1);
         user.setId(id);  
         user = (User) serviceFactory.getUserService().queryVOById(user);
         logger.info("Hello {}","SLF4J");   
         logger.info(">>>>>>>>>>>>>>>>>>"+user.getId());  
         logger.info(">>>>>>>>>>>>>>>>>>"+user.getUserName());  
         logger.info(">>>>>>>>>>>>>>>>>>"+user.getPassWd());  
         logger.info(">>>>>>>>>>>>>>>>>>"+user.getCreateTime());  
         logger.info(">>>>>>>>>>>>>>>>>>"+user.getVisitIp());  
         logger.info(">>>>>>>>>>>>>>>>>>"+user.getLastVisitTime());  
         logger.info(">>>>>>>>>>>>>>>>>>"+user.getLevels());  
         logger.info(">>>>>>>>>>>>>>>>>>"+user.getRoleIds());
         String result = "failure"; 
        taskExecutor.execute(new PrintTask("Thread 1"));
 		taskExecutor.execute(new PrintTask("Thread 2"));
 		taskExecutor.execute(new PrintTask("Thread 3"));
 		taskExecutor.execute(new PrintTask("Thread 4"));
 		taskExecutor.execute(new PrintTask("Thread 5"));
 		// 检查活动的线程，如果活动线程数为0则关闭线程池
 		for (;;) {
 			int count = taskExecutor.getActiveCount();
 			System.out.println("Active Threads : " + count);
 			try {
 				Thread.sleep(1000);
 			} catch (InterruptedException e) {
 				e.printStackTrace();
 			}
 			if (count == 0) {
 				break;
 			}
 		}
        return result;  
     }  
  
     public String getUsername() {  
        return username;  
     }  
  
     public void setUsername(String username) {  
        this.username = username;  
     }  
  
     public String getPassword() {  
        return password;  
     }  
  
     public void setPassword(String password) {  
        this.password = password;  
     }  
}  