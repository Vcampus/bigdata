package cn.edu.seu.bigdata.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.seu.bigdata.bean.Act;
import cn.edu.seu.bigdata.bean.Location;
import cn.edu.seu.bigdata.bean.User;
import cn.edu.seu.bigdata.common.BaseDAO;
import cn.edu.seu.bigdata.dao.ActDAO;
import cn.edu.seu.bigdata.dao.LocationDAO;
import cn.edu.seu.bigdata.dao.UserManageDAO;
import cn.edu.seu.bigdata.service.LocationService;
import cn.edu.seu.bigdata.service.UserManageService;

@Service("locationService")
@Transactional
public class LocationServiceImpl implements LocationService{
	
	private UserManageDAO userManageDAO;
	private LocationDAO locationDAO;
	private ActDAO actDAO;
	
	
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
	


	public Location qryLocationByLatAndLng(double lat, double lng) {
		// TODO Auto-generated method stub
		Location location = locationDAO.getByHQL("from Location l where l.lat=? and l.lng=?",lat,lng);
		return location;
	}
	
	

	
	
	public List<Location> getNearbyLocation(double lat, double lng, int precision) {
		// TODO Auto-generated method stub
		
		List<Location> location = locationDAO.getListByHQL("from Location l where l.lat<=? and l.lat>=? and l.lng<=? and l.lng>=?", lat+precision*0.00001,lat-precision*0.00001,lng+precision*0.00001,lng-precision*0.00001);
		return location;
			
	}

	

	public List<User> getNearbyUser(int lid) {
		// TODO Auto-generated method stub
		Date date = new Date(); 
		Date actPervious;
		Calendar calPervious = Calendar.getInstance();
		List<User> user = new ArrayList<User>();
		User userTemp;
		Act actQry;
		
		List<Act> act= actDAO.getListByHQL("from Act a where a.location_id =?", lid);
		if (!act.isEmpty()){
			for (int i=0;i<act.size();i++){
				actQry = act.get(i);
				
				actPervious = actQry.getRecent_active();
				calPervious.setTime(actPervious);
				calPervious.add(Calendar.MINUTE, 6);
				if (calPervious.after(date)){
					userTemp = userManageDAO.getByHQL("from User u where u.id =?", actQry.getUser_id());
					user.add(userTemp);
				}								
			}						
		}		
		return user;
	}

	public Location saveLocation(double lat, double lng, String tag, String poi,
			String address) {
		Location location = locationDAO.getByHQL("from Location l where l.lat=? and l.lng=?",lat,lng);
		if (location!=null){
			return location;
		}
		else{
			 location= new Location();
			location.setLat(lat);
			location.setLng(lng);
			location.setTag(tag);
			locationDAO.save(location);	
			return location;
			
		}
		
	}	
	
	public Location saveLocationBaiDu(double lat, double lng,  String poi,
            String address) {
        Location location = locationDAO.getByHQL("from Location l where l.poi=?",poi);
        if (location!=null){
            return location;
        }
        else{
             location= new Location();
            location.setLat(lat);
            location.setLng(lng);
            location.setAddress(address);
            location.setPoi(poi);
            location.setTag("0,0,0,0,0,0,0,0,0,0,");

            locationDAO.save(location); 
            return location;
            
        }
        
    }

	public Location qryLocationByAddress(String address) {
		// TODO Auto-generated method stub
		Location location = locationDAO.getByHQL("from Location l where l.address=?",address);
		return location;
	}  
}
