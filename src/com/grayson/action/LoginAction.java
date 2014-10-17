package com.grayson.action;  
import org.springframework.beans.factory.annotation.Autowired;

import com.grayson.service.BaseService;
import com.grayson.vo.User;
import com.opensymphony.xwork2.ActionSupport;
  
public class LoginAction extends ActionSupport {  
     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;  
     private String password;  
     @Autowired
     private BaseService baseService;  
  
     public String execute(){  
         System.out.println(username);  
         System.out.println(password);  
         User user =new User();  
         Integer id = new Integer(1);
         user.setId(id);  
  
         user = (User) baseService.queryVOById(user);  
         System.out.println(">>>>>>>>>>>>>>>>>>"+user.getId());  
         System.out.println(">>>>>>>>>>>>>>>>>>"+user.getUserName());  
         System.out.println(">>>>>>>>>>>>>>>>>>"+user.getPassWd());  
         System.out.println(">>>>>>>>>>>>>>>>>>"+user.getCreateTime());  
         System.out.println(">>>>>>>>>>>>>>>>>>"+user.getVisitIp());  
         System.out.println(">>>>>>>>>>>>>>>>>>"+user.getLastVisitTime());  
         System.out.println(">>>>>>>>>>>>>>>>>>"+user.getLevels());  
         System.out.println(">>>>>>>>>>>>>>>>>>"+user.getRoleIds());  
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
  
     public BaseService getBaseService() {  
        return baseService;  
     }  
  
     public void setBaseService(BaseService baseService) {  
        this.baseService = baseService;  
     }  
}  