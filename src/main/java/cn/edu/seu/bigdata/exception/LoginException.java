package cn.edu.seu.bigdata.exception;

import cn.edu.seu.bigdata.exception.BizException;

public class LoginException extends BizException {

	public static final int ACCOUNT_NOT_EXIST = 10001;
	public static final int PASSWORD_ERROR = 10002;
	public LoginException(int code) {
		super(code);
		// TODO Auto-generated constructor stub
	}
}