package cn.edu.seu.bigdata.exception;

public class RegisterException extends Exception {

	public static final int ACCOUNT_FORMAT_ERROR = 20001;
	public static final int CONFIRM_ERROR = 20002;
	public static final int PASSWORD_TOO_EASY = 20003;
	public static final int ACCOUNT_ALREADY_EXISIT = 20004 ;

	public RegisterException(String code) {
		super(code);
		// TODO Auto-generated constructor stub
	}
}