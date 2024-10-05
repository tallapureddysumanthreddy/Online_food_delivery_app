package com.tap.main;
import com.tap.DAOimpl.Order1DAOimpl;
import java.util.ArrayList;
import com.tap.model.Order1;
public class Order1Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Order1 o= new Order1(2,2022,200,"delivery pending","cash on delivery");
		Order1DAOimpl impl= new Order1DAOimpl();
		int x=impl.insertOrder(o);
		System.out.println(x);
		//Order1DAOimpl oimpl = new Order1DAOimpl();
//		int status = oimpl.updateOrderAcceptingOrderId(3, "Delivery Pending");
//		System.out.println(status+" row/s updated");
//		ArrayList<Order1> al= oimpl.fetchOnOrderId(3);
//		for(Object o:al) {
//		System.out.println(al);
//		}
		//order.insertOrder(1,2022,200,"delivery pending","cash on delivery" )
		
	}

}
