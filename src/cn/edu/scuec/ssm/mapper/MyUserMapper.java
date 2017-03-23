package cn.edu.scuec.ssm.mapper;

import java.util.ArrayList;

import cn.edu.scuec.ssm.po.User;

/**
 * @param
 * @return
 * @throws Exception
 * @author ware E-mail:
 */
public interface MyUserMapper {
	/**
	 * 根据用户名获取用户信息
	 * 一般用于用户登录
	 * @param username
	 * @return
	 */
	ArrayList<User> selectUserByUsername(String username);
}
