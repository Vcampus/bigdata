package cn.edu.seu.bigdata.service;

import cn.edu.seu.bigdata.bean.Act;
import cn.edu.seu.bigdata.bean.User;
import cn.edu.seu.bigdata.dao.ActDAO;

public interface ActService {
  public void saveAct(Act act);
  public void  deleteActByUserId(int uid);
  public void relateUserAndLocation(int uid,int lid);
  
}
