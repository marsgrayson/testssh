package com.grayson.action;  

import javax.jms.Destination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import com.grayson.vo.User;

public class LoginAction extends AbstractAction {  
	
	

	private static final long serialVersionUID = 1L;
	private String username;  
    private String password;  
    @Autowired  
    @Qualifier("queueDestination")  
    private Destination destination; 
    
    
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
         serviceFactory.getProducerService().sendMessage(destination, Thread.currentThread().getName());
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