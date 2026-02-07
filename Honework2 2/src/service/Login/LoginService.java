package service.Login;

import model.Login;

public interface LoginService {
	
	void AddLogin(Login login);
	Login find_login_by_username_and_password(String username,String password);
	boolean find_username(String username);
}
