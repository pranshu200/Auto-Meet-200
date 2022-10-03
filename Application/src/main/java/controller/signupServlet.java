package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MeetingSubmit;
import model.Users;
import service.signupServiceImpl;
import util.userIdGenetator;

/**
 * Servlet implementation class signupServlet
 */
@WebServlet("/signupServlet.do")
public class signupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.service(req, resp);
		String userName=req.getParameter("userName");
		String email=req.getParameter("email");
		String phone=req.getParameter("phone");
		String role=req.getParameter("role");
		int userId=userIdGenetator.generateId(role);
		int credit=0;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		Date date = new Date();
		String lastlogin= formatter.format(date);
		Users user=new Users(userId,userName,email,phone,role,credit,lastlogin);
		signupServiceImpl service=new signupServiceImpl();
		boolean result=service.addUser(user);
		if(result)
		{
		RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
		rd.forward(req, resp);
		}
	}
}
