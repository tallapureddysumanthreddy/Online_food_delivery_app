package com.tap.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodapp.DAOimpl.RestaruantDAOimpl;
import com.foodapp.model.Restaruant;

/**
 * Servlet implementation class RestruantInsertion
 */
@WebServlet("/restruantAdd")
public class RestruantInsertion extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id= Integer.parseInt(req.getParameter("id"));
		String name= req.getParameter("Restruantname");
		int deliveryTime= Integer.parseInt(req.getParameter("deliveryTime"));
		int ratings=Integer.parseInt(req.getParameter("ratings"));
		boolean openOrclose= Boolean.parseBoolean(req.getParameter("openorclose"));
		
		Restaruant r=new Restaruant(id,name,deliveryTime,ratings,openOrclose);
		RestaruantDAOimpl rdao =new RestaruantDAOimpl();
		int status= rdao.insertByRestaruantId(r);
		if(status==1) {
			resp.sendRedirect("success.html");
		}
		else {
			resp.sendRedirect("failure.html");
		}
		
	}
}
