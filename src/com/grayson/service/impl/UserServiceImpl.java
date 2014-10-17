package com.grayson.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grayson.dao.BaseDAO;
import com.grayson.service.AbstractService;
import com.grayson.service.IUserService;
import com.grayson.vo.BaseVO;

@Service("userService")
public class UserServiceImpl extends AbstractService implements IUserService {
	@Autowired
	private BaseDAO baseDAO;
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
	
}
