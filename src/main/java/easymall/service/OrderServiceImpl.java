package easymall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import easymall.dao.CartDao;
import easymall.dao.OrderDao;
import easymall.dao.OrderItemDao;
import easymall.po.OrderItem;
import easymall.po.Orders;
import easymall.pojo.MyCart;
@Service("orderService")
public class OrderServiceImpl implements OrderService {
	@Autowired 
	private OrderDao orderDao;
	@Autowired
	private OrderItemDao orderItemDao;
	@Autowired
	private CartDao cartDao;
	@Override
	@Transactional
	public void addOrder(String cartIds, Orders myOrder) {
		// TODO Auto-generated method stub
		String[] arrCartIds = cartIds.split(",");
		Double sum = 0.0;
		for (String cartID : arrCartIds) {
			Integer cid = Integer.parseInt(cartID);
			MyCart myCart = cartDao.findByCartID(cid);
			String pid = myCart.getPid();
			int buynum = myCart.getNum();
			Double price = myCart.getPrice();
			sum+=buynum*price;
			OrderItem orderItem = new OrderItem();
			orderItem.setOrder_id(myOrder.getId());
			orderItem.setProduct_id(pid);
			orderItem.setBuynum(buynum);
			orderItemDao.addOrderItem(orderItem);
			cartDao.delCart(cid);
		}
		myOrder.setMoney(sum);
		orderDao.addOrder(myOrder);
	}
	@Override
	public List<Orders> findOrderByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return orderDao.findOrderByUserId(userId);
	}
	@Override
	public List<OrderItem> orderitem(String order_id) {
		// TODO Auto-generated method stub
		return orderItemDao.orderItem(order_id);
	}
	@Override
	public void delorder(String id) {
		// TODO Auto-generated method stub
		orderItemDao.delorderitem(id);
		orderDao.delorder(id);
	}
	@Override
	public void payorder(String id) {
		// TODO Auto-generated method stub
		orderDao.payorder(id);
	}

}
