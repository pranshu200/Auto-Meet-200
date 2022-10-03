package service;

import java.util.List;

import repository.AddMemberRepositoryImpl;

public class AddMemberServiceImpl {
	AddMemberRepositoryImpl repo=new AddMemberRepositoryImpl();
	public boolean addMember(String title, int userId, List<Integer> list)
	{
		return repo.addMember(title, userId, list);
	}
}
