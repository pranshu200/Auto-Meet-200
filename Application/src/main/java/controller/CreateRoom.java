package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MeetingSubmit;
import service.createRoomServiceImpl;

/**
 * Servlet implementation class CreateRoom
 */
@WebServlet("/CreateRoom.do")
public class CreateRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String roomName=request.getParameter("roomName");
		int userId=Integer.parseInt(request.getParameter("userId"));
		String date=request.getParameter("date");
		String startTime=request.getParameter("startTime");
		String endTime=request.getParameter("endTime");
		int credit=Integer.parseInt(request.getParameter("credit"));
		String title=request.getParameter("title");
		String type=request.getParameter("type");
		MeetingSubmit meet=new MeetingSubmit(roomName, userId, date, startTime, endTime, credit, title, type);
		createRoomServiceImpl service=new createRoomServiceImpl();
		boolean res=service.addRoom(meet);
		if(res)
		{
			List<MeetingSubmit> list=service.showRoom(userId);
			request.setAttribute("meetingDetails", list);
			RequestDispatcher dd=request.getRequestDispatcher("UserRooms.jsp");
			dd.forward(request, response);
		}
	}

}
