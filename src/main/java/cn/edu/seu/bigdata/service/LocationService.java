package cn.edu.seu.bigdata.service;

import java.util.List;
import java.util.Set;

import cn.edu.seu.bigdata.bean.Location;
import cn.edu.seu.bigdata.bean.User;


public interface LocationService {
	
	public Location qryLocationByLatAndLng(double lat,double lng);
	public Location saveLocation(double lat,double lng,String tag,String poi,String address);
	//lat γ�ȣ�lng ���� precision ����Ϊ��λ�İ뾶Ȧ
	public Location saveLocationBaiDu(double lat,double lng,String poi,String address);
	public List<Location> getNearbyLocation(double lat,double lng,int precision);
	public List<User> getNearbyUser(int lid);
	public Location qryLocationByAddress(String address, String poi);
	public List<Location> getInterLocation(String userTags);
	

}
