package easymall.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.druid.stat.TableStat.Mode;

import easymall.po.OrderItem;
import easymall.po.Orders;
import easymall.po.Products;
import easymall.po.User;
import easymall.pojo.MyCart;
import easymall.pojo.OrderInfo;
import easymall.service.CartService;
import easymall.service.OrderService;
import easymall.service.ProductsService;
import easymall.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController extends BaseController{
	@Autowired
	CartService cartService;
	@Autowired
	OrderService orderService;
	@Autowired
	ProductsService productsService;

	@RequestMapping("/order_add")
	public String order_add(String cartIds, Model model) {
		String[] arrCartIds = cartIds.split(",");
		List<MyCart> carts = new ArrayList<MyCart>();
		for (String string : arrCartIds) {
			Integer cartID = Integer.parseInt(string);
			MyCart cart = cartService.findByCartID(cartID);
			carts.add(cart);
		}
		model.addAttribute("carts", carts);
		model.addAttribute("cartIds", cartIds);
		return "order_add";
	}

	@RequestMapping("/addOrder")
	public String addOrder(String receiverinfo, String cartIds, HttpSession session) {
		String orderId = UUID.randomUUID().toString();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(new Date());
		Timestamp timestamp = Timestamp.valueOf(time);
		User user = (User) session.getAttribute("user");
		Orders myOrder = new Orders(orderId, 0.0, receiverinfo, 0, timestamp, user.getId());
		orderService.addOrder(cartIds, myOrder);
		return "forward:/order/showorder";
	}

	@RequestMapping("/showorder")
	public String showorder(HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");
		List<OrderInfo> orderInfos = findOrderInfoByUserId(user.getId());
		model.addAttribute("orderInfos", orderInfos);
		return "order_list";
	}

	private List<OrderInfo> findOrderInfoByUserId(Integer userId) {
		// TODO Auto-generated method stub
		List<OrderInfo> orderInfos = new ArrayList<OrderInfo>();
		List<Orders> orderList = orderService.findOrderByUserId(userId);

		for (Orders orders : orderList) {
			List<OrderItem> orderitems = orderService.orderitem(orders.getId());
			Map<Products, Integer> map = new HashMap<Products, Integer>();
			for (OrderItem orderItem : orderitems) {
				Products product = productsService.prodInfo(orderItem.getProduct_id());
				map.put(product, orderItem.getBuynum());
			}
			OrderInfo orderInfo = new OrderInfo();
			orderInfo.setOrder(orders);
			orderInfo.setMap(map);
			orderInfos.add(orderInfo);
		}
		return orderInfos;
	}
	@RequestMapping("/delorder")
	public String delorder(String id){
		orderService.delorder(id);
		return "redirect:/order/showorder";
	}
	@RequestMapping("/payorder")
	public String payorder(String id,Model model){
		orderService.payorder(id);
		return "redirect:/order/showorder";
	}
}
