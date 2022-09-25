package service;

import exception.UserNotExistsException;
import model.Users;
import repository.UserDao;

/**
 * 
 * @author The Web Spyder
 */
public class LoginService {
	
	 private UserDao uLogin=new UserDao();
	
	public Users login(int id, String email) {	
	
		try {
		 return uLogin.login(id,email);
		}
		catch(UserNotExistsException ue) {
			throw new RuntimeException(ue);
		}
		
		
	}
	
	public void updateLoginTime(int id, String loginTime) {
		try {
			uLogin.updateLastLoginTime(id, loginTime);
		}catch(RuntimeException re) {
			throw re;
		}
	}
	

}
