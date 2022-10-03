package service;

import java.util.List;

import model.MeetingRoom;
import repository.MeetingListRepository;

public class MeetingRoomServiceImpl {
	MeetingListRepository repo=new MeetingListRepository();
	public List<MeetingRoom> getRoom()
	{
		return repo.Rooms();
	}
	public void addRoom(MeetingRoom rooom)
	{
		repo.createRoom(rooom);
	}
}
