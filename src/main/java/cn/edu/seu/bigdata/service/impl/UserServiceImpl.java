package cn.edu.seu.bigdata.service.impl;

import java.util.Set;

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
	private LocationDAO locationDAO;
	
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

	public void updateUserInfo(int id, int age, String sex, String birthday,
			boolean[] tags, String nickname) throws UpdateUserException {
		
		String tag="";
		User user = userManageDAO.getByHQL("from User u where u.id=?", id);
		if (user==null){
			throw new UpdateUserException(UpdateUserException.USER_NOT_EXIST);
		}else
		{
			

			user.setAge(age);
			user.setNickname(nickname);
			user.setSex(sex);
			Set<Location> location = user.getLocation();
			if (!location.isEmpty()){
				for (Location loc : location){
					computeTag(id,loc.getId(),false);
				}
			}
			for (int i=0;i<10;i++)
			{ 
				if (tags[i]){
					tag = tag + '1'+',';
				}		
				else {
					tag = tag + '0'+',';
				}
			}
			user.setTag(tag);
			
			userManageDAO.update(user);
			if (!location.isEmpty()){
				for (Location loc : location){
					computeTag(id,loc.getId(),true);
				}
			}
		}
		
		// TODO Auto-generated method stub
		
	}
	
	public void computeTag(int userid, int locationid ,boolean AddOrDelete) {
		// TODO Auto-generated method stub
		User user = userManageDAO.getByHQL("from User u where u.id=?", userid);
		Location location = locationDAO.getByHQL("from Location l where u.id=?", locationid);
		String tagUser = user.getTag();
		String tagLocation =location.getTag();
		int [] tagLocationInt= new int[10];
		int srcBegin = -1;
		int srcEnd = tagLocation.indexOf(',', srcBegin+1);
		char[] dst = new char[1000];
		String dstString = String.valueOf(dst);
	
		for (int i=0;i<10;i++){			
			tagLocation.getChars(srcBegin+1, srcEnd-1, dst, 0);
			dstString = String.valueOf(dst);
			tagLocationInt[i] = Integer.valueOf(dstString);
					
			if (i<9){
			srcBegin = srcEnd;
			srcEnd = tagLocation.indexOf(',', srcBegin+1);
			}			
		}	
		for (int i=0;i<10;i++){
			if (tagUser.charAt(2*i)=='1'){
				if (AddOrDelete){
					tagLocationInt[i]++;
				}
				else {
					tagLocationInt[i]--;
				}
			}			
		}
		
		location.setTag(changeTagToString(tagLocationInt));
		locationDAO.save(location);			
		
	}
	
	private String changeTagToString(int[] tag){
		String tagString="";
		for (int i=0;i<tag.length-1;i++){
			tagString = tagString + tag[i]+",";
		}
		tagString = tagString + tag[tag.length-1];		
		return tagString;	
	}

	public void updateUserPassword(int id, String password, String confirm) throws UpdateUserException {
		User user = userManageDAO.getByHQL("from User u where u.id=?", id);
		if (user==null){
			throw new UpdateUserException(UpdateUserException.USER_NOT_EXIST);
		}
		else{
			if (password.equals(confirm))
			{
				user.setPassword(password);
				userManageDAO.update(user);
			}
			else {
				throw new UpdateUserException(UpdateUserException.CONFIRM_ERROR);
			}
		}
		
		// TODO Auto-generated method stub
		
	}
	
	


}
