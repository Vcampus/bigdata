package cn.edu.seu.bigdata.service;

import cn.edu.seu.bigdata.bean.Act;
import cn.edu.seu.bigdata.bean.User;
import cn.edu.seu.bigdata.dao.ActDAO;

public interface ActService {
  public boolean saveAct(Act act);
  public void  deleteActByUserId();
  public void relateUserAndLocation();
  
}
