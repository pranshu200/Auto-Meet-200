package repository;


import java.util.ArrayList;
import java.util.List;

import model.Users;
import util.DatabaseConnection;

public class SignUpRepository {
	List<Users> userlist=DatabaseConnection.openConnection();
	
	public int createUser(Users user)
	{	int res=0;
		if(userlist.contains(user))
			return res;
		else
		{
			userlist.add(user);
			res=1;
		}
		return res;
	}
	
	public List<Users> getUserList() {
		return userlist;
	}
//	private static Connection conn=null;
//	private PreparedStatement ps=null;
	
//	public int createUser(Users user) {
//		int res=0;
//		try{
//			String query="insert into User_Table values(?,?,?,?,?,?,?)";
//		ps=conn.prepareStatement(query);
//		ps.setInt(1,user.getUserId());
//		ps.setString(2, user.getUserName());
//		ps.setString(3, user.getEmail());
//		ps.setString(4,user.getPhone());
//		ps.setString(5, user.getRole());
//		ps.setInt(6,user.getCredit());
//		ps.setString(7,user.getLastLoggedIn());
//		res=ps.executeUpdate();
//		}catch(SQLException e){
//			System.out.println("db error");
//		}
//		return res;
//	}
}
