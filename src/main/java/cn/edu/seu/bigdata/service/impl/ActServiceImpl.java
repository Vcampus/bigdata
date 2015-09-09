package cn.edu.seu.bigdata.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.seu.bigdata.bean.Act;
import cn.edu.seu.bigdata.bean.User;
import cn.edu.seu.bigdata.bean.Location;
import cn.edu.seu.bigdata.dao.ActDAO;
import cn.edu.seu.bigdata.service.ActService;


@Service("ActService")
@Transactional
public class ActServiceImpl implements ActService{
	
	private ActDAO actDAO;

	@Autowired
	public void setUserManageDAO(ActDAO actDAO) {
		this.actDAO = actDAO;
	}

	public boolean saveAct(Act act) {
		// TODO Auto-generated method stub
		actDAO.save(act);
		return false;
	}

	public void relateUserAndLocation() {
		
		// TODO Auto-generated method stub		
	}
}
