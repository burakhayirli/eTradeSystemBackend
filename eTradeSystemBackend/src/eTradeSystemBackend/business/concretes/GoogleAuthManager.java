/*
 * Copyright (C) 2021 <https://github.com/burakhayirli>
 * @author BURAKHAYIRLI
 * Yaz�l�m Geli�tirici Yeti�tirme Kamp� (JAVA + REACT)
 * 7 May 2021
 */
package eTradeSystemBackend.business.concretes;

import eTradeSystemBackend.business.abstracts.AuthService;
import eTradeSystemBackend.business.abstracts.UserService;
import eTradeSystemBackend.dataAccess.abstracts.AuthDao;
import eTradeSystemBackend.db.Users;
import eTradeSystemBackend.entities.concretes.User;

public class GoogleAuthManager implements AuthService {
	AuthDao authDao;
	UserService userService;

	public GoogleAuthManager(AuthDao authDao,UserService userService) {
		super();
		this.authDao = authDao;
		this.userService=userService;
	}

	@Override
	public boolean login(String email, String password) {
		if (authDao.login(email, password)) {
			Users.userList.forEach(u -> {
				if (u.getEmail() == email) {
					System.out.println(
							"Google ile giri� yap�ld�. Ho�geldiniz " + u.getFirstName() + " " + u.getLastName());
				}
			});
			return true;
		} else {
			System.out.println("Google ile giri� ba�ar�s�z. L�tfen bilgileri kontrol ediniz.");
			return false;
		}
	}

	@Override
	public boolean register(User user) {
		userService.add(user);
		return true;

	}

}
