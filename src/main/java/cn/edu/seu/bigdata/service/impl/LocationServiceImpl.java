package cn.edu.seu.bigdata.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.seu.bigdata.bean.Location;
import cn.edu.seu.bigdata.bean.User;
import cn.edu.seu.bigdata.common.BaseDAO;
import cn.edu.seu.bigdata.dao.LocationDAO;
import cn.edu.seu.bigdata.dao.UserManageDAO;
import cn.edu.seu.bigdata.service.LocationService;
import cn.edu.seu.bigdata.service.UserManageService;

@Service("locationService")
@Transactional
public class LocationServiceImpl implements LocationService{
	private UserManageDAO userManageDAO;
	private LocationDAO locationDAO;
	
	
	@Autowired
	public void setUserManageDAO(UserManageDAO userManageDAO) {
		this.userManageDAO = userManageDAO;
	}
	@Autowired
	public void setLocationDAO(LocationDAO locationDAO) {
		this.locationDAO = locationDAO;
	}


	//加上时AddOrDelete ==1 ，减操作AddOrDelete==0
	public void computeTag(int userid, int locationid ,boolean AddOrDelete) {
		// TODO Auto-generated method stub
		User user = userManageDAO.getByHQL("from User u where u.id=?", userid);
		Location location = locationDAO.getByHQL("from Location l where u.id=?", locationid);
		String tagUser = user.getTag();
		String tagLocation =location.getTag();
		int [] tagLocationInt= new int[10];
		int srcBegin = -1;
		int srcEnd = tagLocation.indexOf(',', srcBegin+1);
		char[] dst = new char[1000];
		String dstString = String.valueOf(dst);
	
		for (int i=0;i<10;i++){			
			tagLocation.getChars(srcBegin+1, srcEnd-1, dst, 0);
			dstString = String.valueOf(dst);
			tagLocationInt[i] = Integer.valueOf(dstString);
					
			if (i<9){
			srcBegin = srcEnd;
			srcEnd = tagLocation.indexOf(',', srcBegin+1);
			}			
		}	
		for (int i=0;i<10;i++){
			if (tagUser.charAt(2*i)=='1'){
				if (AddOrDelete){
					tagLocationInt[i]++;
				}
				else {
					tagLocationInt[i]--;
				}
			}			
		}
		
		location.setTag(changeTagToString(tagLocationInt));
		locationDAO.save(location);			
		
	}
	
	private String changeTagToString(int[] tag){
		String tagString="";
		for (int i=0;i<tag.length-1;i++){
			tagString = tagString + tag[i]+",";
		}
		tagString = tagString + tag[tag.length-1];		
		return tagString;
		
	}
	public Location qryLocationByLatAndLng(double lat, double lng) {
		// TODO Auto-generated method stub
		Location location = locationDAO.getByHQL("from Location l where l.lat=? and l.lng=?",lat,lng);
		return location;
	}
	public void saveLocation(double lat, double lng, String tag) {
		// TODO Auto-generated method stub
		Location location= new Location();
		location.setLat(lat);
		location.setLng(lng);
		location.setTag(tag);
		locationDAO.save(location);		
	}
	
	
	

}
