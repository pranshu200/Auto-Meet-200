package service;

import model.Users;
import repository.SignUpRepository;

public class signupServiceImpl {
	private SignUpRepository repo=new SignUpRepository();
	public boolean addUser(Users user)
	{
		boolean res=false;
		int status=repo.createUser(user);
		if(status==1)
				res=true;
		return res;
	}
}
