package org.dnyanyog.dto;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class AuthenticationResponseData {

	private String userName;
	private LocalDate userDoB;
	private String userEmail;
	private String userRole;
	private String code;
	private String message;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public LocalDate getUserDoB() {
		return userDoB;
	}

	public void setUserDoB(LocalDate userDoB) {
		this.userDoB = userDoB;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	public String getUserRole() {
		return userRole;
	}
	
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
