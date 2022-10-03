package repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.MeetingSubmit;
import util.DatabaseConnection;

public class CreateMeetingImpl {
	List<MeetingSubmit> meetList=DatabaseConnection.getMeetingList();
	public boolean createMeeting(MeetingSubmit meet) {
		if(meetList.contains(meet))
			return false;
		else
		{
			meetList.add(meet);
			return true;
		}
	}
	public List<MeetingSubmit> getMeetingList(){
		//System.out.println(meetList);
		return meetList;
	}
	public boolean addRoom(MeetingSubmit meet)
	{
		if(meetList.contains(meet))
			return false;
		else
		{
			meetList.add(meet);
			return true;
		}
	}
	public boolean deleteMeeting(String Title, int userId)
	{
		boolean res=false;
		for (MeetingSubmit m : meetList) {
			if(m.getTitle().equals(Title) && m.getUserId()==userId)
			{
				meetList.remove(m);
				res=true;
				break;
			}
		}
		return res;
	}
	public boolean addMember(String title, int userId ,List<Integer> list)
	{
		boolean res=false;
		for (MeetingSubmit m : meetList) {
			if(m.getTitle().equals(title) && m.getUserId()==userId)
			{	
				m.setUserList(list);
				res=true;
				break;
			}
		}
		return res;
	}
	
}

