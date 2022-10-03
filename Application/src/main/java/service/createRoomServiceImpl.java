package service;

import java.util.List;

import model.MeetingSubmit;
import repository.createRoomRepository;

public class createRoomServiceImpl {
	private createRoomRepository repo=new createRoomRepository();
	public boolean addRoom(MeetingSubmit meet)
	{
			return repo.addRoom(meet);
	}
	public List<MeetingSubmit> showRoom(int id)
	{
		return repo.showRoom(id);
	}
}
