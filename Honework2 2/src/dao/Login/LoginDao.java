package dao.Login;

import java.util.List;

import model.Login;

public interface LoginDao {
	//create
		void add(Login login);
		
		//read
		List<Login> selectByUsernameAndPassword(String username,String password);
		List<Login> selectByUsername(String username);
		
		//update
		
		//delete
}
