package repository;

import java.util.List;

import model.MeetingRoom;
import util.DatabaseConnection;

public class MeetingListRepository {
 List<MeetingRoom> roomlist=DatabaseConnection.getRoom();
  
 public List<MeetingRoom> Rooms(){
	 return roomlist;
 }
 public boolean createRoom(MeetingRoom room)
 {
	 roomlist.add(room);
	 return true;
 }
 
}
