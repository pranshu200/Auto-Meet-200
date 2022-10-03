package service;

import repository.CreateMeetingImpl;
import repository.DeleteRoomRepositoryImpl;

public class DeleteRoomServiceImpl {
	DeleteRoomRepositoryImpl repo=new DeleteRoomRepositoryImpl();
	public boolean delete(String title,int id)
	{
		return repo.deleteRoom(title, id);
	}
}
