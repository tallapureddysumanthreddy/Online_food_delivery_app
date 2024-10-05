package com.tap.DAO;
import com.tap.model.OrderItems;
import java.util.ArrayList;
public interface OrderItemsDAO {
	int insertOrderItem(OrderItems orderitems);
	ArrayList<OrderItems>fetchOrderItems(int order_id);
}
