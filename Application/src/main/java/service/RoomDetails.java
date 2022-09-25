package service;

import java.util.HashMap;
import java.util.List;

import model.MeetingRoom;
import repository.DisplayRoomDetails;


/**
 * 
 * @author The Web Spyder
 *
 */
public class RoomDetails {
	
	private DisplayRoomDetails ds=new DisplayRoomDetails();
	
	public HashMap<String,Integer> getRoomCount(){
		String[] rooms= {"Online Training","Classroom Training","Conference Call Facility","Business"};
		
		HashMap<String ,Integer> rc= ds.roomCount();
		
		for(int i=0;i<rooms.length;i++) {
			if(!rc.containsKey(rooms[i])) {
				rc.put(rooms[i], 0);
			}
		}
		
		return rc;
	}
	
	public List<MeetingRoom> getRoomList(){
		return ds.roomList();
	}
	
	public List<String> typeList(String roomName){
		return ds.getTypes(roomName);
	}

}
