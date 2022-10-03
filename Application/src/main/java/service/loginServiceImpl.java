package service;

import java.util.ArrayList;
import java.util.List;

import model.MeetingSubmit;
import model.Users;
import repository.LoginRepository;

public class loginServiceImpl {
	LoginRepository repo=new LoginRepository();
	Users user=null;
	public Users userLogin(String userName, String email)
	{
		boolean res=false;
		user=repo.login(userName, email);
		return user;
	}
	public List<MeetingSubmit> getMeeting(int id)
	{
		List<MeetingSubmit> list=new ArrayList<>();
		list=repo.getUserMeeting(id);
		System.out.println(list);
		return list;
	}
}
