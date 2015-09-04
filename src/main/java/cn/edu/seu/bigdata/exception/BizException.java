package cn.edu.seu.bigdata.exception;

public class BizException extends Exception {
	private int code;

	public BizException(int code) {
		super();
		this.code = code;
	}
	
}