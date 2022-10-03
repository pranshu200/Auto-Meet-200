package model;

import java.sql.Time;
import java.util.List;

/**
 * 
 * @author The Web Spyder
 *
 */
public class MeetingSubmit {

	private String roomName;
	private int userId;
	private String date;
	private String startTime;
	private String endTime;
	private int credit;
	private String title;
	private String meetingType;
	private List<Integer> userList;

	public MeetingSubmit() {
		// TODO Auto-generated constructor stub
	}

	public MeetingSubmit(String roomName, int userId, String date, String startTime, String endTime, int credit,
			String title, String meetingType) {
		super();
		this.roomName = roomName;
		this.userId = userId;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.credit = credit;
		this.title = title;
		this.meetingType = meetingType;
	}

	public MeetingSubmit(String roomName, int userId, String date, String startTime, String endTime, int credit,
			String title, String meetingType, List<Integer> userList) {
		super();
		this.roomName = roomName;
		this.userId = userId;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.credit = credit;
		this.title = title;
		this.meetingType = meetingType;
		this.userList = userList;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMeetingType() {
		return meetingType;
	}

	public void setMeetingType(String meetingType) {
		this.meetingType = meetingType;
	}

	public List<Integer> getUserList() {
		return userList;
	}

	public void setUserList(List<Integer> userList) {
		this.userList = userList;
	}

	@Override
	public String toString() {
		return "MeetingSubmit [roomName=" + roomName + ", userId=" + userId + ", date=" + date + ", startTime="
				+ startTime + ", endTime=" + endTime + ", credit=" + credit + ", title=" + title + ", meetingType="
				+ meetingType + ", userList=" + userList + "]";
	}


}
