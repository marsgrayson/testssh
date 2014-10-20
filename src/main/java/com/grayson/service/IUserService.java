package com.grayson.service;

import java.util.List;

import com.grayson.vo.BaseVO;
import com.grayson.vo.User;

public interface IUserService {
	 public BaseVO addVO(BaseVO vo);  
     public boolean deleteVOById(BaseVO vo);  
     public void updateVO(BaseVO vo);  
     public BaseVO queryVOById(BaseVO user);  
     public List<BaseVO> queryVO(BaseVO obj);  
     public List<BaseVO> queryVOBySQL(String sql);  
     public List<BaseVO> queryAll();  
     public boolean updateAndAddVO(User vo);
}
