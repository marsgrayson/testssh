package com.grayson.action;  

import org.springframework.web.portlet.bind.annotation.ActionMapping;

import com.grayson.vo.User;
 

//@RequestMapping("/login")
public class LoginAction extends AbstractAction {  
	
	private static final long serialVersionUID = 1L;
	private String username;  
    private String password;  

   // @RequestMapping("/doLogin")
   // @ActionMapping
     public String login(){  
         logger.debug(username);  
         logger.debug(password);  
         User user =new User();  
         Integer id = new Integer(1);
         user.setId(id);  
         user = (User) serviceFactory.getUserService().queryVOById(user);
         logger.info("Hello {}","SLF4J");   
         logger.debug(">>>>>>>>>>>>>>>>>>"+user.getId());  
         logger.debug(">>>>>>>>>>>>>>>>>>"+user.getUserName());  
         logger.debug(">>>>>>>>>>>>>>>>>>"+user.getPassWd());  
         logger.debug(">>>>>>>>>>>>>>>>>>"+user.getCreateTime());  
         logger.debug(">>>>>>>>>>>>>>>>>>"+user.getVisitIp());  
         logger.debug(">>>>>>>>>>>>>>>>>>"+user.getLastVisitTime());  
         logger.debug(">>>>>>>>>>>>>>>>>>"+user.getLevels());  
         logger.debug(">>>>>>>>>>>>>>>>>>"+user.getRoleIds());  
         String result = "success";  
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