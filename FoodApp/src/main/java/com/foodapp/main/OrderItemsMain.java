package com.foodapp.main;
import java.util.ArrayList;
import com.foodapp.DAOimpl.OrderItemsDAOimpl;
import com.foodapp.model.OrderItems;
public class OrderItemsMain {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OrderItems oi = new OrderItems(3,1101,3,200);
		OrderItemsDAOimpl oiimpl = new OrderItemsDAOimpl();
//		int result = oiimpl.insertOrderItem(oi);
//		System.out.println(result);
		 ArrayList <OrderItems> al= oiimpl.fetchOrderItems(2);
		System.out.println(al);
	}

}
