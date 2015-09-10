package cn.edu.seu.bigdata.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.seu.bigdata.bean.User;
import cn.edu.seu.bigdata.dao.UserManageDAO;
import cn.edu.seu.bigdata.exception.LoginException;
import cn.edu.seu.bigdata.exception.RegisterException;
import cn.edu.seu.bigdata.exception.UpdateUserException;
import cn.edu.seu.bigdata.service.UserManageService;

import cn.edu.seu.bigdata.bean.Location;
import cn.edu.seu.bigdata.dao.LocationDAO;


@Service("userManageService")
@Transactional
public class UserServiceImpl implements UserManageService{
   
	private UserManageDAO userManageDAO;
	
	@Autowired
	public void setUserManageDAO(UserManageDAO userManageDAO) {
		this.userManageDAO = userManageDAO;
	}

	public User loginByAccoutAndPassword(String userAccout, String userPwd)
			throws LoginException {
		User user = userManageDAO.getByHQL("from User u where u.name=?", userAccout);
		if (user==null)
			throw new LoginException(LoginException.ACCOUNT_NOT_EXIST);
		if (!userPwd.equals(user.getPassword()))
			throw new LoginException(LoginException.PASSWORD_ERROR);
		return user;
	}

	public void register(String userAccout, String userPwd, String confirmPwd)
			throws RegisterException {
		// TODO Auto-generated method stub
		if(userPwd==null||!userPwd.equals(confirmPwd)){
			throw new RegisterException(RegisterException.CONFIRM_ERROR);
		}
		
		User user = userManageDAO.getByHQL("from User u where u.name=?", userAccout);
		if(user !=null){
			throw new RegisterException(RegisterException.ACCOUNT_ALREADY_EXISIT);
		}
		user = new User();
		user.setName(userAccout);
		user.setPassword(userPwd);
		user.setTag("0,0,0,0,0,0,0,0,0,0");
		userManageDAO.save(user);
		
	}

	public void updateUser(User user) throws UpdateUserException {
		// TODO Auto-generated method stub
		userManageDAO.update(user);
		
	}

	public User findUserByAccount(String Account) {
		// TODO Auto-generated method stub
		User user = userManageDAO.getByHQL("from User u where u.name=?", Account);
		return user;
	}

	public User findUserByID(int uid) {
		// TODO Auto-generated method stub
		User user = userManageDAO.getByHQL("from User u where u.id=?", uid);
		return user;
	}
	
	//删除数据库中用户的信息并删除Action表中与该用户有关的信息同时更新location的tag信息
	public void deleteUSer(int uid) {
		User user = userManageDAO.getByHQL("from User u where u.id=?", uid);
		userManageDAO.deleteById(uid);			
		

	}

}
