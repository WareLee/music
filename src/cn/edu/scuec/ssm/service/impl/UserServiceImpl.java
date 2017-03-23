package cn.edu.scuec.ssm.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.scuec.ssm.mapper.MyUserMapper;
import cn.edu.scuec.ssm.mapper.UserMapper;
import cn.edu.scuec.ssm.po.User;
import cn.edu.scuec.ssm.service.UserService;

/**
 * @param
 * @return
 * @throws Exception
 * @author ware E-mail:
 */
public class UserServiceImpl implements UserService {
	
	@Autowired
	private MyUserMapper myUserMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public ArrayList<User> findUserByUsername(String username) throws Exception{
		
		return myUserMapper.selectUserByUsername(username);
	}

	@Override
	public int insertUser(User user) throws Exception {
		return userMapper.insert(user);
	}

}
