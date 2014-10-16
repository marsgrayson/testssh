package com.zzb.dao;  
  
import java.util.List;  
import com.zzb.vo.BaseVO;  
  
public interface BaseDAO {  
     public BaseVO addVO(BaseVO vo);  
     public boolean deleteVOById(BaseVO vo);  
     public void updateVO(BaseVO vo);  
     public BaseVO getVOById(BaseVO id);  
     public List<BaseVO> queryVO(BaseVO obj);  
     public List<BaseVO> queryVOBySQL(String sql);  
     public List<BaseVO> queryAll();  
}   