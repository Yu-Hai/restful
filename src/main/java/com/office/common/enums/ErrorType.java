package com.office.common.enums;

/**
 * 错误类型枚举类 
 * @author Neo
 *
 */
public enum ErrorType {

	ERROR_UNKNOW(), ERROR_DATA(), ERROR_VAILDATE();

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
