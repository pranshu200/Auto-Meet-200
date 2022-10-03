package repository;

import java.util.List;

public class AddMemberRepositoryImpl {
	CreateMeetingImpl repo=new CreateMeetingImpl();
	public boolean addMember(String title, int userid, List<Integer> list)
	{
		return repo.addMember(title, userid, list);
	}
}
