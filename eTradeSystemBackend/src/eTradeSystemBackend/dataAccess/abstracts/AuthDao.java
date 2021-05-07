/*
 * Copyright (C) 2021 <https://github.com/burakhayirli>
 * @author BURAKHAYIRLI
 * Yaz�l�m Geli�tirici Yeti�tirme Kamp� (JAVA + REACT)
 * 6 May 2021
 */
package eTradeSystemBackend.dataAccess.abstracts;

public interface AuthDao {

	boolean login(String email,String password);
	boolean register(String email, String password);
}
