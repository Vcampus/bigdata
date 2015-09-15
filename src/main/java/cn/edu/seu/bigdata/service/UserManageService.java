package cn.edu.seu.bigdata.service;

import cn.edu.seu.bigdata.bean.User;
import cn.edu.seu.bigdata.exception.LoginException;
import cn.edu.seu.bigdata.exception.RegisterException;
import cn.edu.seu.bigdata.exception.UpdateUserException;


public interface UserManageService {
	public User loginByAccoutAndPassword(String userAccout,String userPwd) throws LoginException;
	public void register(String userAccout,String userPwd,String confirmPwd) throws RegisterException;
	public void updateUserInfo(int id,int age,String sex,String tags ,String nickname ) throws UpdateUserException;
	public void updateUserPassword(int id,String password,String confirm) throws UpdateUserException;;
	public void computeTag(int userid, int locationid ,boolean AddOrDelete);
	public User findUserByAccount(String Account) ;
	public User findUserByID( int uid);
	public void deleteUSer(int uid);
}
