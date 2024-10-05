package com.tap.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodapp.DAOimpl.MenuDAOimpl;
import com.foodapp.model.Menu;

/**
 * Servlet implementation class MenuInsertion
 */
@WebServlet("/Menuinsertion")
public class MenuInsertion extends HttpServlet {
	
	@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int restaruantid=Integer.parseInt(req.getParameter("Restruantid"));
		int menuid= Integer.parseInt(req.getParameter("Menuid"));
		
		String itemName=req.getParameter("name") ;
		String description= req.getParameter("description");
		int price= Integer.parseInt(req.getParameter("price"));
		String status= req.getParameter("availableOrNot");
		String imagepath=req.getParameter("imagepath");
		Menu m;
		if(status.equals("Available")) {
		 m= new Menu (menuid,restaruantid,itemName,description,price,true,imagepath);
		}
		else {
		 m = new Menu (menuid,restaruantid,itemName,description,price,false,imagepath);
		}
		
		MenuDAOimpl mdao=  new MenuDAOimpl();
		int x=mdao.insertmenu(m);
		
		if(x==1) {
			resp.sendRedirect("success.html");
		}
		else {
			resp.sendRedirect("failure.html");
		}
		
		
		}
	

}