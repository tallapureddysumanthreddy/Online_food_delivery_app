package com.foodapp.main;

import com.foodapp.DAOimpl.OrderHistoryDAOimpl;
import com.foodapp.model.OrderHistory;
import java.util.ArrayList;
public class OrderHistoryMain {
	public static void main(String[] args) {
		OrderHistoryDAOimpl ohimpl= new OrderHistoryDAOimpl();
//		int status = ohimpl.updateOrderHistory(3,"delivered");
//		System.out.println(status);
		OrderHistory oh = new OrderHistory(3,4,200,"Delivery pending");
		int x= ohimpl.insertOrderHistory1(oh);
		System.out.println(x);
		ArrayList<OrderHistory>al = ohimpl.fetchOrdersOnUserid(3);
		System.out.println(al);
	}
}
