/*
 * Copyright (C) 2021 <https://github.com/burakhayirli>
 * @author BURAKHAYIRLI
 * Yazýlým Geliþtirici Yetiþtirme Kampý (JAVA + REACT)
 * 6 May 2021
 */
package eTradeSystemBackend.dataAccess.concretes;

import eTradeSystemBackend.dataAccess.abstracts.AuthDao;
import eTradeSystemBackend.dataAccess.abstracts.UserDao;
import eTradeSystemBackend.entities.concretes.User;

public class HibernateAuthDao implements AuthDao {

	UserDao userdao;

	public HibernateAuthDao(UserDao userdao) {
		super();
		this.userdao = userdao;
	}

	@Override
	public boolean login(String email, String password) {
		User user = userdao.getByMail(email);
		if (user != null) {
			if (user.getPassword() == password)
				return true;
			else
				return false;
		}
		return false;

	}

	@Override
	public boolean register(String email, String password) {
		return false;
	}

}
