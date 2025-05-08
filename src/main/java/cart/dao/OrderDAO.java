package cart.dao;

import java.util.List;

import cart.model.entity.Order;
import cart.model.entity.OrderItem;

public interface OrderDAO {
	// 通過userId建立訂單
	Integer addOrder(Integer userId);
	// 訂單明細
	void addOrderItem(Integer orderId, Integer productId, Integer quantity);
	// 查詢一位使用者的訂單
	List<Order> findAllOrdersByUserId(Integer userId);
	// 查詢訂單明細
	List<OrderItem> findAllOrderItemsByUserId(Integer userId);
}
