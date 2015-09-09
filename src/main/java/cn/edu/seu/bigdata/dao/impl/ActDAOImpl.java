package cn.edu.seu.bigdata.dao.impl;

import org.springframework.stereotype.Repository;

import cn.edu.seu.bigdata.common.BaseDAOImpl;
import cn.edu.seu.bigdata.bean.Act;
import cn.edu.seu.bigdata.dao.ActDAO;

@Repository("ActDAO")
public class ActDAOImpl extends BaseDAOImpl<Act, Integer> implements ActDAO {

}
