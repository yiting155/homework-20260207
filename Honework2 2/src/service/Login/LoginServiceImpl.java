package service.Login;

import java.util.List;

import dao.Login.LoginDaoImpl;
import model.Login;
import util.Tool;

public class LoginServiceImpl implements LoginService{

	/*public static void main(String []args) {
		System.out.println();
	}*/
	
	LoginDaoImpl loginDaoImpl=new LoginDaoImpl();
	
	@Override
	public void AddLogin(Login login) {
		loginDaoImpl.add(login);
		
	}

	
	
	@Override
	public Login find_login_by_username_and_password(String username, String password) {
		Login login=null;
		List<Login> l=loginDaoImpl.selectByUsernameAndPassword(username, password);
		if(l.size()!=0) 
		{
			login=l.get(0);
		}
		return login;
	}
	

	@Override
	public boolean find_username(String username) {
		List<Login> l=loginDaoImpl.selectByUsername(username);
		return !l.isEmpty();
	}

}
