package cn.edu.seu.bigdata.service;

import java.util.Date;



public interface ActService {
  public void saveAct(int uid,int lid,Date times);
  public void  deleteActByUserId(int uid);
  public void relateUserToLocation(int uid,int lid);
}
