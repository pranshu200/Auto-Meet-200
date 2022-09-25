package service;

import java.util.List;

import model.MeetingDataForUser;
import repository.UserDao;


/**
 * 
 * @author The Web Spyder
 *
 */
public class MemberService {
	
	private UserDao userDao=new UserDao();
	
	public List<MeetingDataForUser> meetings(int userid){
		
		try {
			return userDao.getMeetings(userid);
		}
		catch(RuntimeException re) {
			throw re;
		}
		
	}
	
	

}