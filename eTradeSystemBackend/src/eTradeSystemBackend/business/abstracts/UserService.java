/*
 * Copyright (C) 2021 <https://github.com/burakhayirli>
 * @author BURAKHAYIRLI
 * Yaz�l�m Geli�tirici Yeti�tirme Kamp� (JAVA + REACT)
 * 6 May 2021
 */
package eTradeSystemBackend.business.abstracts;

import eTradeSystemBackend.entities.concretes.User;

public interface UserService {
	void add(User user);
	User getByEmail(String email);
	boolean verifyEmail(User user,String code);
}
