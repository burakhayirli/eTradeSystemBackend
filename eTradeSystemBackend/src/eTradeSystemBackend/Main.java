/*
 * Copyright (C) 2021 <https://github.com/burakhayirli>
 * @author BURAKHAYIRLI
 * Yazýlým Geliþtirici Yetiþtirme Kampý (JAVA + REACT)
 * 6 May 2021
 */
package eTradeSystemBackend;

import eTradeSystemBackend.business.abstracts.AuthService;
import eTradeSystemBackend.business.concretes.EmailAuthManager;
import eTradeSystemBackend.business.concretes.GoogleAuthManager;
import eTradeSystemBackend.business.concretes.UserManager;
import eTradeSystemBackend.dataAccess.concretes.HibernateAuthDao;
import eTradeSystemBackend.dataAccess.concretes.HibernateUserDao;
import eTradeSystemBackend.db.Users;
import eTradeSystemBackend.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		UserManager userManager = new UserManager(new HibernateUserDao());
		AuthService authManagerWithEmail = new EmailAuthManager(new HibernateAuthDao(new HibernateUserDao()),new UserManager(new HibernateUserDao()));

		User user = new User(1, "Burak", "HAYIRLI", "burak@burak.com", "123456", "265477");
		User user2 = new User(2, "Engin", "DEMÝROÐ", "engin@engin.com", "123456", "265478");
		
		authManagerWithEmail.register(user);

		if (user.isSentEmail()) {
			userManager.verifyEmail(user, "265477");
		}

		authManagerWithEmail.login("burak@burak.com", "123456");
		System.out.println("Mevcut Kullanýcý Sayýsý: " + Users.userList.size());
		System.out.println("\n");

		AuthService authManagerWithGoogle = new GoogleAuthManager(new HibernateAuthDao(new HibernateUserDao()),new UserManager(new HibernateUserDao()));
		
		authManagerWithGoogle.register(user2);

		if (user2.isSentEmail()) {
			userManager.verifyEmail(user2, "265478");
		}

		authManagerWithGoogle.login("engin@engin.com", "123456");
		System.out.println("Mevcut Kullanýcý Sayýsý: " + Users.userList.size());
	}
}
