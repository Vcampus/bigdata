package cn.edu.seu.bigdata.exception;

public class UpdateUserException extends BizException {
	public static final int NET_ERROR = 30001;
	public static final int PASSWORD_ERROR = 30002;
	public static final int USER_NOT_EXIST = 30003;
	public static final int CONFIRM_ERROR = 30003;

	public UpdateUserException(int code) {
		super(code);
		// TODO Auto-generated constructor stub
	}
}
