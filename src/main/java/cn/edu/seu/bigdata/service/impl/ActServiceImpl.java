package cn.edu.seu.bigdata.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

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
	public void setActDAO(ActDAO actDAO) {
		this.actDAO = actDAO;
	}
	
	@Autowired
	public void setLocationDAO(LocationDAO locationDAO) {
		this.locationDAO = locationDAO;
	}
	
	@Autowired
	public void setUserManageDAO(UserManageDAO userManageDAO) {
		this.userManageDAO = userManageDAO;
	}

	
	

	public void saveAct(int uid,int lid) {
		// TODO Auto-generated method stub
		Date date = new Date(); 
		Date actPervious;
		double lasted = 0;
		
		Calendar cal=Calendar.getInstance();
		Calendar calPervious = Calendar.getInstance();
		cal.setTime(date);
		
		boolean flag=false;
		List<Act> act = actDAO.getListByHQL("from Act a where a.user_id=? and a.location_id=?",uid,lid);
		if (!act.isEmpty()){	
			for (int i=0;i<act.size();i++)
			{
				Act actPer = act.get(i);
				actPervious = actPer.getRecent_active();
				calPervious.setTime(actPervious);
				calPervious.add(Calendar.MINUTE, 6);
				if (calPervious.after(cal)){
					flag = true;
					actPer.setLasttime(actPer.getLasttime()+5.0/60);
					actPer.setRecent_active(date);
					actDAO.update(actPer);
				}	
				lasted = lasted + actPer.getLasttime();
			}
			
			if (lasted>=100)
				relateUserToLocation(uid,lid);	
		}
		if ((act.isEmpty()) ||(flag=false)){
			Act actNow = new Act();
			
			actNow.setUser_id(uid);
			actNow.setLocation_id(lid);
			
			actNow.setStarttime(date);
			actNow.setLasttime(5.0/60);
			actNow.setRecent_active(date);
			actDAO.save(actNow);
		} 	
	}

	public void relateUserToLocation(int uid, int lid ) {
		
		// TODO Auto-generated method stub	
		Location location = locationDAO.getByHQL("from Location l where l.id=? ", lid);
		User user = userManageDAO.getByHQL("from User u where u.id=? ", uid);
		Set<Location> s1 = user.getLocation();
		s1.add(location);
		user.setLocation(s1);
		userManageDAO.save(user);
		computeTag(uid, lid);	
	}

	public void deleteActByUserId(int uid) {
		// TODO Auto-generated method stub
	
		 List<Act> act = actDAO.getListByHQL("from Act a where a.user_id=?", uid);
		 for ( int i=0;i<act.size();i++){
		    actDAO.delete(act.get(i));
		 }
		
	}

	
	private void computeTag(int userid, int locationid) {
		// TODO Auto-generated method stub
		
		User user = userManageDAO.getByHQL("from User u where u.id=?", userid);
		Location location = locationDAO.getByHQL("from Location l where l.id=?", locationid);
		String tagUser = user.getTag();
		String tagLocation =location.getTag();
		int [] tagLocationInt= new int[10];
		String tagString="";
		int srcBegin = -1;
		int srcEnd = tagLocation.indexOf(',', srcBegin+1);
		char[] dst =new char[20];
		for(int i=0;i<20;i++)
		{
			dst[i] = '0';
		}
		
		String dstString = "";
		
		for (int i=0;i<10;i++){		
		
			tagLocation.getChars(srcBegin+1, srcEnd, dst,21-srcEnd+srcBegin);
			dstString = String.valueOf(dst);
			for(int j=0;j<20;j++)
			{
				dst[j] = '0';
			}
			
			tagLocationInt[i] = Integer.valueOf(dstString);
			if (i<9){
			srcBegin = srcEnd;
			srcEnd = tagLocation.indexOf(',', srcBegin+1);
			}			
		}	
		
		for (int i=0;i<10;i++){
			if (tagUser.charAt(2*i)=='1'){	
					tagLocationInt[i]++;
			}			
		}
		
		for (int i=0;i<tagLocationInt.length;i++){
			tagString = tagString + tagLocationInt[i]+",";
		}

		location.setTag(tagString);
		locationDAO.save(location);			
		
	}
}
