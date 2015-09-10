package cn.edu.seu.bigdata.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.seu.bigdata.bean.Act;
import cn.edu.seu.bigdata.bean.User;
import cn.edu.seu.bigdata.bean.Location;
import cn.edu.seu.bigdata.dao.ActDAO;
import cn.edu.seu.bigdata.dao.LocationDAO;
import cn.edu.seu.bigdata.dao.UserManageDAO;
import cn.edu.seu.bigdata.service.ActService;


@Service("ActService")
@Transactional
public class ActServiceImpl implements ActService{
	
	private ActDAO actDAO;
	private LocationDAO locationDAO;
	private UserManageDAO userManageDAO;
	
	
	@Autowired
	public void setUserManageDAO(UserManageDAO userManageDAO) {
		this.userManageDAO = userManageDAO;
	}
	@Autowired
	public void setLocationDAO(LocationDAO locationDAO) {
		this.locationDAO = locationDAO;
	}
	
	@Autowired
	public void setLocationDAO(ActDAO actDAO) {
		this.actDAO = actDAO;
	}

	public void saveAct(int uid,int lid,Date times) {
		// TODO Auto-generated method stub
		Act act = actDAO.getByHQL("from Act a where a.user_id=? and a.location_id=?",uid,lid);
		if (act==null){			
		act = new Act();
		act.setUser_id(uid);
		act.setLocation_id(lid);
		act.setStarttime(times);
		act.setLasttime(1.0/60);
		} 
		else{
			act.setLasttime(act.getLasttime()+1/60);
		}
		actDAO.save(act);
	}

	public void relateUserAndLocation(int uid, int lid ) {
		
		// TODO Auto-generated method stub	
		
	}

	public void deleteActByUserId(int uid) {
		// TODO Auto-generated method stub
		Act act = actDAO.getByHQL("from Act a where a.userid=?", uid);
		actDAO.delete(act);
		
	}
}
