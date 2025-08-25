package org.dnyanyog.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "authentication",
	   uniqueConstraints = {
			   @UniqueConstraint(columnNames = "user_email"),
			   @UniqueConstraint(columnNames = "user_name")
	   },
	   indexes = {
			   @Index(columnList = "user_email"),
			   @Index(columnList = "user_name")
	   })
public class Authentication {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer userId;

	@Column(name = "user_name", nullable = false)
	private String userName;

	@Column(name = "password")
	private String password;

	@Column(name = "user_DoB", nullable = false)
	private LocalDate userDob;

	@Column(name = "user_email", nullable = false)
	private String userEmail;
	
	@Column(name = "role", nullable = false)
	private String userRole;

	public static Authentication getInstance() {
		return new Authentication();
	}

	public Integer getUserId() {
		return userId;
	}

	public Authentication setUserId(Integer userId) {
		this.userId = userId;
		return this;
	}

	public String getUserName() {
		return userName;
	}

	public Authentication setUserName(String userName) {
		this.userName = userName;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public Authentication setPassword(String password) {
		this.password = password;
		return this;
	}

	public LocalDate getUserDob() {
		return userDob;
	}

	public Authentication setUserDob(LocalDate userDob) {
		this.userDob = userDob;
		return this;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public Authentication setUserEmail(String userEmail) {
		this.userEmail = userEmail;
		return this;
	}
	
	public String getUserRole() {
		return userRole;
	}
	
	public Authentication setUserRole(String userRole) {
		this.userRole = userRole;
		return this;
	}

}