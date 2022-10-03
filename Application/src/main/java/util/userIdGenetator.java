package util;


import java.util.ArrayList;
import java.util.List;

import model.Users;
/**
 * 
 * @author The Web Spyder
 *
 */
public class userIdGenetator {
		public static int generateId(String role) {
			List<Users> userList=new ArrayList<>();
			userList=DatabaseConnection.openConnection();
			int id=0,userid=0;
			for (Users users : userList) {
				if(users.getRole().equalsIgnoreCase(role))
				{
					id=users.getUserId();
				}
			}
			if(role.equalsIgnoreCase("Admin"))
			{
				userid=101+(id-100);
			}
			if(role.equalsIgnoreCase("Manager"))
			{
				userid=1001+(id-1000);
			}
			if(role.equalsIgnoreCase("Member"))
			{
				userid=10001+(id-10000);
			}
			
			return userid;
			
//			//Connection conn = null;
//			//Statement stmt=null;	
//			//DatabaseConnection Dbcon=new DatabaseConnection();
//			try {
//				conn = Dbcon.openConnection();
//				System.out.println("Connection Established");
//				if(role.equalsIgnoreCase("Admin"))
//				{
//					String query = "Select max(user_id) from User_Table where user_role in ('Admin')";
//					ResultSet res=stmt.executeQuery(query);
//					while(res.next())
//					{
//						int userid=res.getInt("User_Id");
//						id="100" + Integer.toString((userid-100)+1);
//					}
//				}
//				if(role.equalsIgnoreCase("Manager"))
//				{
//					String query = "Select max(user_id) from User_Table where user_role in ('Manager')";
//					ResultSet res=stmt.executeQuery(query);
//					while(res.next())
//					{
//						int userid=res.getInt("User_Id");
//						id="1000" + Integer.toString((userid-1000)+1);
//						System.out.println(id);
//					}
//				}
//				if(role.equalsIgnoreCase("Member"))
//				{
//					String query = "Select max(user_id) from User_Table where user_role in ('Member')";
//					ResultSet res=stmt.executeQuery(query);
//					while(res.next())
//					{
//						int userid=res.getInt("User_Id");
//						id="10000" + Integer.toString((userid-10000)+1);
//					}
//				}
//
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			System.out.println(Integer.parseInt(id));
//			return Integer.parseInt(id);
		}
}
