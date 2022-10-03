package repository;

import java.util.ArrayList;
import java.util.List;

import model.MeetingSubmit;
import model.Users;
import util.DatabaseConnection;

public class LoginRepository {
	List<Users> userlist=new ArrayList<>();	
	SignUpRepository repo= new SignUpRepository();
	Users u1=null;
	CreateMeetingImpl meet=new CreateMeetingImpl();
	public Users login(String userName, String email) {
		userlist= repo.getUserList();
		for (Users users : userlist) {
			if(users.getUserName().equalsIgnoreCase(userName) && users.getEmail().equalsIgnoreCase(email))
			{
				u1= users;
			}
		}
		if(u1!=null)
			return u1;
		else
			return null;	
	}
	
	public List<MeetingSubmit> getUserMeeting(int id)
	{
		List<MeetingSubmit> list=meet.getMeetingList();
		List<MeetingSubmit> userMeetingList=new ArrayList<>();
//		System.out.println(id);
//		System.out.println(list);
		for (MeetingSubmit m : list) {
			if(m.getUserId()==id)
				userMeetingList.add(m);
		}
		System.out.println();
		return userMeetingList;
	}
	public boolean createUserRoom(MeetingSubmit m)
	{
		return meet.createMeeting(m);
	}
	
}
