package cn.edu.scuec.ssm.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.scuec.ssm.staticdata.Singlen;

/**
 * <p>判断token</p>
 * @param
 * @return
 * @throws Exception
 * @author ware E-mail:
 */
public class SinglenInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object arg2) throws Exception {
		// 获取请求url
		String url = request.getRequestURI();
		if (url.indexOf("login.action") >= 0
				|| url.indexOf("register.action") >= 0
				|| url.indexOf("logout.action") >= 0) {
			return true;
		} else {
			for (Cookie cook : request.getCookies()) {
				if (cook.getName().equals("token")) {
					if (Singlen.getToken() != null
							&& cook.getValue().equals(Singlen.getToken())) {
						return true;
					} else {
						request.getRequestDispatcher("/login.html").forward(
								request, response);
					}
				}
			}
		}

		return false;
	}

}
