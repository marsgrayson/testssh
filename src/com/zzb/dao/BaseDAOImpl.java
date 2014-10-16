package com.zzb.dao;  
  
import java.util.List;  

import org.hibernate.Session;
import org.hibernate.SessionFactory;  
import org.springframework.beans.factory.annotation.Autowired;

import com.zzb.vo.BaseVO;  
  
public class BaseDAOImpl implements BaseDAO {  
	@Autowired
     private SessionFactory sessionFactory;  
  
     public BaseVO addVO(BaseVO vo) {  
        return null;  
     }  
  
     public boolean deleteVOById(BaseVO vo) {  
        return false;  
     }  
  
     public BaseVO getVOById(BaseVO vo) {  
        assert(vo.getId()!=null);  
        Session session=sessionFactory.openSession();
         BaseVO result = (BaseVO)session.load(vo.getClass(), vo.getId());  
         
        return result;  
     }  
  
     public List<BaseVO> queryAll() {  
        return null;  
     }  
  
     public List<BaseVO> queryVO(BaseVO vo) {  
        return null;  
     }  
  
     public List<BaseVO> queryVOBySQL(String sql) {  
        return null;  
     }  
  
     public void updateVO(BaseVO vo) {   
  
     }  
  
     public SessionFactory getSessionFactory() {  
        return sessionFactory;  
     }  
  
     public void setSessionFactory(SessionFactory sessionFactory) {  
        this.sessionFactory = sessionFactory;  
     }  
}  