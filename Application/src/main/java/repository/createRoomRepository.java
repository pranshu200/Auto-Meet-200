package repository;

import java.util.ArrayList;
import java.util.List;

import model.MeetingSubmit;

public class createRoomRepository {
	private CreateMeetingImpl meet=new CreateMeetingImpl();
	public boolean addRoom(MeetingSubmit m)
	{
		return meet.addRoom(m);
	}
	public List<MeetingSubmit> showRoom(int id)
	{
		List<MeetingSubmit> list1=meet.getMeetingList();
		List<MeetingSubmit> meet=new ArrayList<>();
		for (MeetingSubmit m : list1) {
			if(m.getUserId()==id)
				meet.add(m);
		}
		return meet;
	}
}
