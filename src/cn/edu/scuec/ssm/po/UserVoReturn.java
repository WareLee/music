package cn.edu.scuec.ssm.po;


/**
 * <p>
 * 登录请求的返回pojo(最终会被转成json)
 * </p>
 * 
 * @param
 * @return
 * @throws Exception
 * @author ware E-mail:
 */
public class UserVoReturn {
	private String lastTime;
	private int userId;
	private String username; // 用户名
	private int code; // 返回码
	private int state; // 处理状态,是否成功
	private String token; // 验证token
	private int sessionSid; //
	private String message; 

	public String getLastTime() {
		return lastTime;
	}

	public void setLastTime(String lastTime) {
		this.lastTime = lastTime;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getSessionSid() {
		return sessionSid;
	}

	public void setSessionSid(int sessionSid) {
		this.sessionSid = sessionSid;
	}

}