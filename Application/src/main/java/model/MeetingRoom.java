package model;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author The Web Spyder
 *
 */
public class MeetingRoom {

	private String roomName;
	private int capacity;
	private double rating;
	private int noOfRating;
	private int perHourCost;
	private String[] amenities;
	private String roomTypes;
	public MeetingRoom() {
	}
	public MeetingRoom(String roomName, int capacity, double rating, int noOfRating, int perHourCost, String[] amenities,
			String roomTypes) {
		super();
		this.roomName = roomName;
		this.capacity = capacity;
		this.rating = rating;
		this.noOfRating = noOfRating;
		this.perHourCost = perHourCost;
		this.amenities = amenities;
		this.roomTypes = roomTypes;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public int getNoOfRating() {
		return noOfRating;
	}
	public void setNoOfRating(int noOfRating) {
		this.noOfRating = noOfRating;
	}
	public int getPerHourCost() {
		return perHourCost;
	}
	public void setPerHourCost(int perHourCost) {
		this.perHourCost = perHourCost;
	}
	public String[] getAmenities() {
		return amenities;
	}
	public void setAmenities(String[] amenities) {
		this.amenities = amenities;
	}
	public String getRoomTypes() {
		return roomTypes;
	}
	public void setRoomTypes(String roomTypes) {
		this.roomTypes = roomTypes;
	}
	@Override
	public String toString() {
		return "MeetingRoom [roomName=" + roomName + ", capacity=" + capacity + ", rating=" + rating + ", noOfRating="
				+ noOfRating + ", perHourCost=" + perHourCost + ", amenities=" + Arrays.toString(amenities)
				+ ", roomTypes=" + roomTypes + "]";
	}
	
	

}
