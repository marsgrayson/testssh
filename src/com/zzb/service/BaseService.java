package com.zzb.service;  
  
import java.util.List;  
import com.zzb.vo.BaseVO;  
  
public interface BaseService {  
     public BaseVO addVO(BaseVO vo);  
     public boolean deleteVOById(BaseVO vo);  
     public void updateVO(BaseVO vo);  
     public BaseVO getVOById(BaseVO user);  
     public List<BaseVO> queryVO(BaseVO obj);  
     public List<BaseVO> queryVOBySQL(String sql);  
     public List<BaseVO> queryAll();  
}  