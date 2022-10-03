package util;


import java.sql.Connection;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import model.MeetingRoom;
import model.MeetingSubmit;
import model.Users;

public class DatabaseConnection {
	private static Connection conn=null;
	
	public static List<Users>  openConnection()
	{
		
		List<Users> userlist=new ArrayList<>();
		Users u1=new Users(101,"pranshu","pran@gmail.com","9416666687","Admin",0,"2020-10-01 00:00:01");
		Users u2=new Users(1001,"piyush","piyu@gmail.com","9416666697","Manager",0,"2020-10-01 00:00:01");
		Users u3=new Users(10001,"likitha","liki@gmail.com","9415566687","Member",0,"2020-10-01 00:00:01");
		
//	Class.forName("org.apache.derby.jdbc.ClientDriver");
//		//Class.forName("com.mysql.jdbc.Driver");
//		System.out.println("Class load!");
//		conn=DriverManager.getConnection("jdbc:derby://localhost:1527/AutoMeetdb");
//	//	conn=DriverManager.getConnection( "jdbc:mysql://localhost:3306/sonoo","root","2020");  
//		System.out.println("Connection Established!");
//		return conn;
		userlist.add(u1);
		userlist.add(u2);
		userlist.add(u3);
		return userlist;
	}
	
	public static List<MeetingRoom> getRoom()
	{
		List<MeetingRoom> roomlist=new ArrayList<>();
		String[] a1= {"Projector","Wifi Connection"};
		String[] a2= {"Whiteboard","Water Dispenser"};
		String[] a3= {"Water Dispenser","Projector"};
		MeetingRoom r1=new MeetingRoom("01-101",50,4.5,30,20,a1,"Training");
		MeetingRoom r2=new MeetingRoom("02-102",30,4,10,40,a2,"Business");
		MeetingRoom r3=new MeetingRoom("02-103",50,5,50,50,a1,"Project");
		
		roomlist.add(r1);
		roomlist.add(r2);
		roomlist.add(r3);
		return roomlist;	
	}
	public static List<MeetingSubmit> getMeetingList(){
		List<MeetingSubmit> list=new ArrayList<>();
		List<Integer> l1= new ArrayList<>();
		l1.add(1001);
		l1.add(10001);
		MeetingSubmit m1=new MeetingSubmit("TR5",101,"2020-10-01" , "00:12:00", "00:13:00", 50, "The Web Spyder","Education",l1);
		list.add(m1);
		return list;
	}
}
