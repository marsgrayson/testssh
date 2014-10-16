package com.grayson.vo;  
  
import java.io.Serializable;   
  
public class BaseVO implements Serializable {  
     /**
	 * 
	 */
	private static final long serialVersionUID = 4311251180967064775L;
	private Integer id;  
  
     public Integer getId() {  
        return id;  
     }  
  
     public void setId(Integer id) {  
        this.id = id;  
     }  
}  