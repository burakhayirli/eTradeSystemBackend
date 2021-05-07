/*
 * Copyright (C) 2021 <https://github.com/burakhayirli>
 * @author BURAKHAYIRLI
 * Yazýlým Geliþtirici Yetiþtirme Kampý (JAVA + REACT)
 * 6 May 2021
 */
package eTradeSystemBackend.dataAccess.concretes;

import eTradeSystemBackend.dataAccess.abstracts.UserDao;
import eTradeSystemBackend.db.Users;
import eTradeSystemBackend.entities.concretes.User;

public class HibernateUserDao implements UserDao {

	@Override
	public void add(User user) {
		System.out.println("Hibernate :" + "Yeni kullanýcý eklendi. " + user.getFirstName() + " " + user.getLastName()
				+ " " + user.getEmail());
		Users.userList.add(user);

	}

	@Override
	public void update(User user) {
		System.out.println("Hibernate :" + "Kullanýcý güncellendi. " + user.getFirstName() + " " + user.getLastName()
				+ " " + user.getEmail());
	}

	@Override
	public void delete(User user) {
		System.out.println("Hibernate :" + "Kullanýcý silindi. " + user.getFirstName() + " " + user.getLastName() + " "
				+ user.getEmail());
		Users.userList.remove(user);

	}

	@Override
	public User getByMail(String email) {
		for (User user : Users.userList) {
			if (user.getEmail() == email) {
				return user;
			}
		}
		return null;
	}

}
