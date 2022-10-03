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
import service.DeleteRoomServiceImpl;
import service.createRoomServiceImpl;

/**
 * Servlet implementation class DeleteRoomServlet
 */
@WebServlet("/DeleteRoomServlet.do")
public class DeleteRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title=request.getParameter("title");
		int userId=Integer.parseInt(request.getParameter("userId"));
		List<Integer> list=new ArrayList<>();
		list.add(1001);
		list.add(1002);
		DeleteRoomServiceImpl service=new DeleteRoomServiceImpl();
		createRoomServiceImpl serv=new createRoomServiceImpl();
		boolean res=service.delete(title, userId);
		List<MeetingSubmit> l=serv.showRoom(userId);
		request.setAttribute("meetingDetails", l);
		RequestDispatcher dd=request.getRequestDispatcher("UserRooms.jsp");
		dd.forward(request, response);
	}

}
