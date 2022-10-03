package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MeetingSubmit;
import service.AddMemberServiceImpl;
import service.createRoomServiceImpl;

/**
 * Servlet implementation class AddMember
 */
@WebServlet("/AddMember.do")
public class AddMember extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title=request.getParameter("title");
		int userId=Integer.parseInt(request.getParameter("userId"));
		List<Integer> list=new ArrayList<>();
		list.add(1001);
		list.add(1002);
		AddMemberServiceImpl service=new AddMemberServiceImpl();
		createRoomServiceImpl serv=new createRoomServiceImpl();
		boolean res=service.addMember(title, userId, list);
		List<MeetingSubmit> l=serv.showRoom(userId);
		request.setAttribute("meetingDetails", l);
		RequestDispatcher dd=request.getRequestDispatcher("UserRooms.jsp");
		dd.forward(request, response);
	}

}
