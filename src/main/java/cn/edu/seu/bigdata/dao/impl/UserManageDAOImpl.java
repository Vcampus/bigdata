package cn.edu.seu.bigdata.dao.impl;

import org.springframework.stereotype.Repository;

import cn.edu.seu.bigdata.bean.User;
import cn.edu.seu.bigdata.common.BaseDAOImpl;
import cn.edu.seu.bigdata.dao.UserManageDAO;

@Repository("userManageDAO")
public class UserManageDAOImpl extends BaseDAOImpl<User, Integer> implements UserManageDAO {


}
