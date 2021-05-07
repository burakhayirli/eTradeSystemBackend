/*
 * Copyright (C) 2021 <https://github.com/burakhayirli>
 * @author BURAKHAYIRLI
 * Yazýlým Geliþtirici Yetiþtirme Kampý (JAVA + REACT)
 * 6 May 2021
 */
package eTradeSystemBackend.entities.concretes;

import eTradeSystemBackend.core.entities.Entity;

public class User implements Entity {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private boolean isSentEmail;
	private boolean isVerifiedEmail;
	private String emailVerifyCode;

	public User() {
	}

	public User(int id, String firstName, String lastName, String email, String password, String emailVerifyCode) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.emailVerifyCode = emailVerifyCode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isSentEmail() {
		return isSentEmail;
	}

	public void setSentEmail(boolean isSentEmail) {
		this.isSentEmail = isSentEmail;
	}

	public boolean isVerifiedEmail() {
		return isVerifiedEmail;
	}

	public void setVerifiedEmail(boolean isVerifiedEmail) {
		this.isVerifiedEmail = isVerifiedEmail;
	}

	public String getEmailVerifyCode() {
		return emailVerifyCode;
	}

	public void setEmailVerifyCode(String emailVerifyCode) {
		this.emailVerifyCode = emailVerifyCode;
	}



}
