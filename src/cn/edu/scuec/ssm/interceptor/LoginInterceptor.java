package cn.edu.scuec.ssm.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 * 拦截除了登录,注册,退出以外的所有请求
 * </p>
 * 
 * @param
 * @return
 * @throws Exception
 * @author ware E-mail:
 */
public class LoginInterceptor implements HandlerInterceptor {

	// 拦截除了登录,注册,退出以外的请求,判断session是否是新的
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// 获取请求url
		String url = request.getRequestURI();
		if (url.indexOf("login.action") >= 0
				|| url.indexOf("register.action") >= 0
				|| url.indexOf("logout.action") >= 0
				|| url.indexOf("index.html") >= 0) {
			return true;
		} else {
			HttpSession session = request.getSession();
			if (session != null) {
				for (Cookie cook : request.getCookies()) {
					if (cook.getName().equals("username")) {
						if(cook.getValue().equals(session.getAttribute("username"))){
							return true;
						}
					}
				}
				request.getRequestDispatcher("/login.html").forward(request, response);
				return false;
			}
		}
		request.getRequestDispatcher("/login.html").forward(request, response);
		return false;
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {

	}

}
