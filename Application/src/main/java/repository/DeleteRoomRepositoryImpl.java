package repository;

public class DeleteRoomRepositoryImpl {
	CreateMeetingImpl repo=new CreateMeetingImpl();
	public boolean deleteRoom(String title, int userId)
	{
		return repo.deleteMeeting(title, userId);
	}
}
