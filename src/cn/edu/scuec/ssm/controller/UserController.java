package cn.edu.scuec.ssm.controller;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.scuec.ssm.po.User;
import cn.edu.scuec.ssm.po.UserVoReturn;
import cn.edu.scuec.ssm.service.UserService;
import cn.edu.scuec.ssm.staticdata.Singlen;
import cn.edu.scuec.ssm.utils.MD5;

/**
 * <p>
 * 负责用户的登录,注册,退出
 * </p>
 * 
 * @param
 * @return
 * @throws Exception
 * @author ware E-mail:
 */
@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value="/login",method=RequestMethod.POST)
	public @ResponseBody UserVoReturn login(HttpServletRequest request,@Validated User user, BindingResult bindingResult) throws Exception {
		
		UserVoReturn userVoRet=new UserVoReturn();
		
		// 判断密码是否为空
		  if(user.getPassword()==null || user.getPassword().trim().equals("")){
				  String lastTime="";
				  String username="";
				  String token="";
				  int userId=-1;
			
				  // 获取所有的cookie值
				  Cookie[] cookies = request.getCookies();
				  Cookie cookie = null;
				  for (int i = 0; i < cookies.length; i++) {
					   cookie = cookies[i];
					   if (cookie.getName().equals("username")) {
						   username=cookie.getValue();
					   }
					   if (cookie.getName().equals("lastTime")) {
						   lastTime=cookie.getValue();
					   }
					   if (cookie.getName().equals("token")) {
						   token=cookie.getValue();
					   }
					   if (cookie.getName().equals("userId")) {
						   userId=Integer.parseInt(cookie.getValue());
					   }
				  }
			 
				if(MD5.getMD5Code(username+lastTime+userId).equals(token)){
					// 验证成功
					userVoRet.setCode(1);
					userVoRet.setSessionSid(userId);
					userVoRet.setUserId(userId);
					userVoRet.setState(1);
					userVoRet.setToken(token);
					userVoRet.setUsername(user.getUsername());
					userVoRet.setLastTime(lastTime);
					
					return userVoRet;
				}
		  }
		
		
		// 密码验证
		ArrayList<User> userList=userService.findUserByUsername(user.getUsername());
		if(userList!=null && userList.size()==1){
			if(userList.get(0).getPassword().equals(user.getPassword())){
				// 存储token
				String date=new Date().toString();
				String token=MD5.getMD5Code(userList.get(0).getUsername()+date+userList.get(0).getId());
				Singlen.setToken(token);
				
				request.getSession().setAttribute("username", user.getUsername());
				request.getSession().setAttribute("token", token);
				request.getSession().setAttribute("lastTime", date);
				
				// 验证成功
				userVoRet.setCode(1);
				userVoRet.setSessionSid(userList.get(0).getId());
				userVoRet.setUserId(userList.get(0).getId());
				userVoRet.setState(1);
				userVoRet.setToken(token);
				userVoRet.setUsername(user.getUsername());
				userVoRet.setLastTime(date);
				
				return userVoRet;
			}
		}
		
		// 验证失败
		userVoRet.setCode(0);
		userVoRet.setState(0);
		
		return userVoRet;
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.POST)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:login.html";

	}

	@RequestMapping(value="/register",method=RequestMethod.POST)
	public @ResponseBody UserVoReturn insertNewUser(HttpServletRequest request, @Validated User user, BindingResult bindingResult) throws Exception {
		UserVoReturn userVoRet = new UserVoReturn();
		
		// 插入新用户信息
		if(userService.findUserByUsername(user.getUsername()).size()<1 ){
			if( userService.insertUser(user)>=1){
				
				ArrayList<User> myself=userService.findUserByUsername(user.getUsername());
				// 存储token,并返回相关信息
				String token=MD5.getMD5Code(new Date().toString());
				Singlen.setToken(token);
				
				request.getSession().setAttribute("username", user.getUsername());
				request.getSession().setAttribute("token", token);
				
				userVoRet.setUserId(myself.get(0).getId());
				userVoRet.setCode(1);
				userVoRet.setSessionSid(0);
				userVoRet.setState(1);
				userVoRet.setToken(token);
				userVoRet.setUsername(user.getUsername());
				userVoRet.setMessage("注册成功");
			}
		}else{
			userVoRet.setCode(0);
			userVoRet.setSessionSid(0);
			userVoRet.setState(0);
			userVoRet.setMessage("用户名已存在");
			
		}
		
		return userVoRet;
	}

}
