package cn.edu.seu.bigdata.dao.impl;
import org.springframework.stereotype.Repository;

import cn.edu.seu.bigdata.common.BaseDAOImpl;
import cn.edu.seu.bigdata.bean.Location;
import cn.edu.seu.bigdata.dao.LocationDAO;

@Repository("locationDAO")
public class LocationDAOImpl extends BaseDAOImpl<Location, Integer> implements LocationDAO{

}
