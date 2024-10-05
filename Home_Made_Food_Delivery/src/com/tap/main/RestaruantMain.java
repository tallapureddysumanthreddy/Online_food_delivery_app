package com.tap.main;
import com.tap.model.Restaruant;
import com.tap.DAOimpl.RestaruantDAOimpl;

import java.sql.ResultSet;
import java.util.List;
public class RestaruantMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Restaruant r = new Restaruant(10,"Andhra Spicy",10,5,true);
		RestaruantDAOimpl rimpl=new RestaruantDAOimpl();
//		int status = rimpl.insertByRestaruantId(r);
//		System.out.println(status);
		//RestaruantMain main = new RestaruantMain();
//		List<Restaruant> al=(List<Restaruant>) rimpl.getAllRestaruants();
//		 for(Restaruant a:al) {
//			 System.out.println(a);
//		 }
		//System.out.println(al);
//		int status = rimpl.updateAvailabilityByRestaruantId(10, false);
//		System.out.println(status);
		Restaruant al = rimpl.getRestaruantById(2021);
		System.out.println(al);
	}

}
