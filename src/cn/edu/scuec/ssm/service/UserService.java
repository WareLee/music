package cn.edu.scuec.ssm.service;

import java.util.ArrayList;

import cn.edu.scuec.ssm.po.User;

/**
 * @param
 * @return
 * @throws Exception
 * @author ware E-mail:
 */
public interface UserService {

	public ArrayList<User> findUserByUsername(String username) throws Exception;
	public int insertUser(User user) throws Exception;

}