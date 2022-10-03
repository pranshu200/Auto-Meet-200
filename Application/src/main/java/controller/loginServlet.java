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
import model.Users;
import service.loginServiceImpl;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet.do")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("userName");
		String email = req.getParameter("email");
		Users user = null;
		List<MeetingSubmit> meetinglist = null;
		loginServiceImpl service = new loginServiceImpl();
		user = service.userLogin(userName, email);
		//System.out.println(user);
		if (user != null) {
			int id = user.getUserId();
			String role = user.getRole();
			if (role.equals("Admin")) {
				req.setAttribute("userinfo", user);
				meetinglist = service.getMeeting(id);
				//System.out.println(meetinglist);
				req.setAttribute("meetingInfo", meetinglist);
				RequestDispatcher rd=req.getRequestDispatcher("AdminLogin.jsp");
				rd.forward(req, resp);
			}
			if (role.equals("Manager")) {
				req.setAttribute("userinfo", user);
				meetinglist = service.getMeeting(id);
				req.setAttribute("meetingInfo", meetinglist);
				RequestDispatcher rd=req.getRequestDispatcher("ManagerLogin.jsp");
				rd.forward(req, resp);
			}
			if (role.equals("Member")) {
				req.setAttribute("userinfo", user);
				meetinglist = service.getMeeting(id);
				req.setAttribute("meetingInfo", meetinglist);
				RequestDispatcher rd=req.getRequestDispatcher("MemberLogin.jsp");
				rd.forward(req, resp);
			}

		}

	}

}
