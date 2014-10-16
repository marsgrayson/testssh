package com.zzb.service;  
  
import java.util.List;  
import com.zzb.dao.BaseDAO;  
import com.zzb.vo.BaseVO;  
  
public class BaseServiceImpl implements BaseService {  
     BaseDAO baseDao;  
  
     public BaseVO addVO(BaseVO vo) {  
        return null;  
     }  
  
     public boolean deleteVOById(BaseVO vo) {  
        return false;  
     }  
  
     public BaseVO getVOById(BaseVO BaseVO) {  
        return (BaseVO)baseDao.getVOById(BaseVO);  
     }  
  
      public List<BaseVO> queryAll() {  
       return null;  
     }  
  
     public List<BaseVO> queryVO(BaseVO obj) {  
        return null;  
     }  
  
     public List<BaseVO> queryVOBySQL(String sql) {  
        return null;  
     }  
  
     public void updateVO(BaseVO vo) {   
  
     }  
  
     public BaseDAO getBaseDao() {  
        return baseDao;  
     }  
  
     public void setBaseDao(BaseDAO baseDao) {  
        this.baseDao = baseDao;  
     }  
}  