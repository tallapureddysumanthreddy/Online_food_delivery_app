package com.tap.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodapp.DAOimpl.UserDAOIMPLEMENTATION;
import com.foodapp.model.User;

/**
 * Servlet implementation class RegisterUser
 */
@WebServlet("/addUser")
public class RegisterUser extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username= req.getParameter("username");
		String email= req.getParameter("email");
		String password= req.getParameter("password");
		String address=req.getParameter("address");
		
		
		User u = new User (username, email,password,address);
		UserDAOIMPLEMENTATION udao = new UserDAOIMPLEMENTATION();
		int status = udao.insertuser(u);
		if(status==1) {
			resp.sendRedirect("success.html");
		}
		
		else {
			resp.sendRedirect("failure.html");
		}
	}
}
