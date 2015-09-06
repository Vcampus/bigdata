package cn.edu.seu.bigdata.service;


import cn.edu.seu.bigdata.bean.User;
import cn.edu.seu.bigdata.exception.LoginException;
import cn.edu.seu.bigdata.exception.RegisterException;
import cn.edu.seu.bigdata.exception.UpdateUserException;


public interface UserManageService {
	public User loginByAccoutAndPassword(String userAccout,String userPwd) throws LoginException;
	public void register(String userAccout,String userPwd,String confirmPwd) throws RegisterException;
	public void updateUser(User user) throws UpdateUserException;
	public User findUserByAccount(String Account) ;
	public boolean saveUser(User user) ;
	public User findUserByID( int uid);
	public void deleteUSer(String uid);
	

}
