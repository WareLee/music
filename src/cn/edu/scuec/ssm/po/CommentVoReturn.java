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
public class CommentVoReturn {
	private int code; // 返回码
	private int state; // 处理状态,是否成功
	private String message; // 返回说明信息


	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}


	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


}