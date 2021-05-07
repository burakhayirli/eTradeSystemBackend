/*
 * Copyright (C) 2021 <https://github.com/burakhayirli>
 * @author BURAKHAYIRLI
 * Yazýlým Geliþtirici Yetiþtirme Kampý (JAVA + REACT)
 * 6 May 2021
 */
package eTradeSystemBackend.business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eTradeSystemBackend.business.abstracts.UserService;
import eTradeSystemBackend.dataAccess.abstracts.UserDao;
import eTradeSystemBackend.db.Users;
import eTradeSystemBackend.entities.concretes.User;

public class UserManager implements UserService {

	UserDao userDao;

	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public void add(User user) {
		if (checkIfPasswordValid(user) & checkIfEmailCorrect(user) & checkIfFirstNameCorrect(user)
				& checkIfLastNameCorrect(user) & !checkIfExistsUser(user)) {
			userDao.add(user);
			user.setSentEmail(true);
			System.out.println("Doðrulama e-postasý gönderildi. Doðrulama Kodu: " + user.getEmailVerifyCode());

		}
	}

	private boolean checkIfExistsUser(User user) {

		for (User newUser : Users.userList) {
			if (newUser.getEmail() == user.getEmail()) {
				return true;
			}
		}
		return false;
	}

	private boolean checkIfLastNameCorrect(User user) {
		if (user.getLastName().length() >= 2) {
			return true;
		} else {
			System.out.println("Soyad en az iki karakterden oluþmalýdýr.");
			return false;
		}
	}

	private boolean checkIfFirstNameCorrect(User user) {
		if (user.getFirstName().length() >= 2) {
			return true;
		} else {
			System.out.println("Ad en az iki karakterden oluþmalýdýr.");
			return false;
		}
	}

	private boolean checkIfEmailCorrect(User user) {

		String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(user.getEmail());

		if (matcher.matches()) {
			return true;
		} else {
			System.out.println("E-posta alaný e-posta formatýnda olmalýdýr.");
			return false;
		}
	}

	private boolean checkIfPasswordValid(User user) {
		if (user.getPassword().length() < 6) {
			System.out.println("Parola en az 6 karakterden oluþmalýdýr.");
			return false;
		} else
			return true;
	}

	@Override
	public User getByEmail(String email) {
		return userDao.getByMail(email);
	}

	@Override
	public boolean verifyEmail(User user, String code) {

		if (user.getEmailVerifyCode() == code) {
			user.setVerifiedEmail(true);
			System.out.println(user.getEmail()+" E-Posta doðrulandý. Giriþ yapabilirsiniz.");
			return true;
		} else {
			System.out.println(user.getEmail()+" E-Posta doðrulama hatalý, lütfen tekrar deneyiniz.");
			return false;
		}
	}

}
