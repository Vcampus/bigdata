package cn.edu.seu.bigdata.service;

import java.util.List;
import java.util.Set;

import cn.edu.seu.bigdata.bean.Location;
import cn.edu.seu.bigdata.bean.User;


public interface LocationService {
	
	public void computeTag(int userid, int locationid, boolean AddOrDelete);
	public Location qryLocationByLatAndLng(double lat,double lng);
	public void saveLocation(double lat,double lng,String tag);
	//lat 纬度，lng 经度 precision 以米为单位的半径圈 
	public List<Location> getNearbyLocation(double lat,double lng,int precision);
	public List<User> getNearbyUser(int lid);
	

}
