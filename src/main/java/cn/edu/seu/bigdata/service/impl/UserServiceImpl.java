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
		// TODO Auto-generated method stub
		return null;
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
		
		userManageDAO.save(user);
		
	}

	public void updateUser(User user) throws UpdateUserException {
		// TODO Auto-generated method stub
		
	}

	public int findUserByAccount(String Account) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean saveUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	public User findUserByID(int uid) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteUSer(String uid) {
		// TODO Auto-generated method stub
		
	}

}
