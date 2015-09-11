package cn.edu.seu.bigdata.service;

import java.util.List;
import java.util.Set;

import cn.edu.seu.bigdata.bean.Location;
import cn.edu.seu.bigdata.bean.User;


public interface LocationService {
	
	public void computeTag(int userid, int locationid, boolean AddOrDelete);
	public Location qryLocationByLatAndLng(double lat,double lng);
	public void saveLocation(double lat,double lng,String tag);
	//lat γ�ȣ�lng ���� precision ����Ϊ��λ�İ뾶Ȧ 
	public List<Location> getNearbyLocation(double lat,double lng,int precision);
	public List<User> getNearbyUser(int lid);
	

}
