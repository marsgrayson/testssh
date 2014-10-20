package com.grayson.service.impl;

import java.util.Date;
import java.util.List;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grayson.dao.BaseDAO;
import com.grayson.service.AbstractService;
import com.grayson.service.IUserService;
import com.grayson.vo.BaseVO;
import com.grayson.vo.User;

@Service("userService")
public class UserServiceImpl extends AbstractService implements IUserService {
	@Autowired
	private BaseDAO baseDAO;
	
	public final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	@Override
	public BaseVO addVO(BaseVO vo) {
		logger.debug("addVO");
		return baseDAO.addVO(vo);
	}

	@Override
	public boolean deleteVOById(BaseVO vo) {
		return baseDAO.deleteVOById(vo);
	}

	@Override
	public void updateVO(BaseVO vo) {
		baseDAO.updateVO(vo);
	}

	@Override
	public BaseVO queryVOById(BaseVO vo) {
		return baseDAO.getVOById(vo);
	}

	@Override
	public List<BaseVO> queryVO(BaseVO vo) {
		return baseDAO.queryVO(vo);
	}

	@Override
	public List<BaseVO> queryVOBySQL(String sql) {
		return baseDAO.queryVOBySQL(sql);
	}

	@Override
	public List<BaseVO> queryAll() {
		return baseDAO.queryAll();
	}

	public BaseDAO getBaseDAO() {
		return baseDAO;
	}

	public void setBaseDAO(BaseDAO baseDAO) {
		this.baseDAO = baseDAO;
	}

	@Override
	@Transactional 
	public synchronized boolean  updateAndAddVO(User bvo) {
		if(bvo==null)
		return false;
		User vo= bvo;
		vo.setId(1);
		User t=(User) baseDAO.getVOById(vo);
		t.setCreateTime(new Date());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int maxId=baseDAO.queryMaxId("User");
		maxId++;
		logger.info("-------------------------maxid : {}",maxId);
		t.setId(maxId);
		this.baseDAO.addVO(t);
		return true;
	}
	
}
