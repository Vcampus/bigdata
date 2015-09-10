package cn.edu.seu.bigdata.service;

import cn.edu.seu.bigdata.bean.Location;


public interface LocationService {
	
	public void computeTag(int userid, int locationid, boolean AddOrDelete);
	public Location qryLocationByLatAndLng(double lat,double lng);
	public void saveLocation(double lat,double lng,String tag);

}
