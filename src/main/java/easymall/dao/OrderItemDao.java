package easymall.dao;

import java.util.List;

import easymall.po.OrderItem;

public interface OrderItemDao {

	void addOrderItem(OrderItem orderItem);

	List<OrderItem> orderItem(String order_id);

	void delorderitem(String id);

}
