package cart.service;

import java.util.List;

import cart.model.dto.OrderDTO;
import cart.model.dto.ProductDTO;

public interface OrderService {
	// 建立訂單
	void addOrder(Integer userId, List<ProductDTO> cart);
	// 查詢所有訂單
	List<OrderDTO> findAllOrdersByUserId(Integer userId);
}
