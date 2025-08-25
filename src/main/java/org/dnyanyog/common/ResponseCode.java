package org.dnyanyog.common;

public enum ResponseCode {

	SUCCESS_ADD_USER("000", "User added successfully"), 
	FAIL_ADD_USER("400", "Failed to add user"),
	SUCCESS_AUTHENTICATION("000", "User login successfully"), 
	FAIL_AUTHENTICATION("AUTH1003", "Authentication failed"),
	UNKOWN_ERROR("AUTH0911", "Internal server error"),
	FAIL_LOGIN("0911", "username and password both are mandatory!");

	private final String code;
	private final String message;
	
	ResponseCode(String code, String message){
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
	
	

}
