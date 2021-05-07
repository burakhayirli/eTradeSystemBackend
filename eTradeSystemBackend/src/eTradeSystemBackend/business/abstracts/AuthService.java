/*
 * Copyright (C) 2021 <https://github.com/burakhayirli>
 * @author BURAKHAYIRLI
 * Yaz�l�m Geli�tirici Yeti�tirme Kamp� (JAVA + REACT)
 * 7 May 2021
 */
package eTradeSystemBackend.business.abstracts;

import eTradeSystemBackend.entities.concretes.User;

public interface AuthService {
	boolean login(String email, String password);
	boolean register(User user);
}
