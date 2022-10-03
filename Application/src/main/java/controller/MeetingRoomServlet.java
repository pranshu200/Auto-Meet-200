package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MeetingRoom;
import service.MeetingRoomServiceImpl;

/**
 * Servlet implementation class MeetingRoomServlet
 */
@WebServlet("/MeetingRoomServlet.do")
public class MeetingRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			MeetingRoomServiceImpl service=new MeetingRoomServiceImpl();
			//System.out.println("Method Called!");
			List<MeetingRoom> list=service.getRoom();
			//System.out.println(list);
			req.setAttribute("roomlist", list);
			RequestDispatcher rd=req.getRequestDispatcher("MeetingRoom.jsp");
			rd.forward(req, resp);
		}
}
