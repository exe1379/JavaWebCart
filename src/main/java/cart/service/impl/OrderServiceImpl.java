package cart.service.impl;

import java.util.ArrayList;
import java.util.List;

import cart.model.dto.OrderDTO;
import cart.model.dto.OrderItemDTO;
import cart.model.dto.ProductDTO;
import cart.model.entity.Order;
import cart.model.entity.OrderItem;
import cart.service.OrderService;
import cart.dao.OrderDAO;
import cart.dao.impl.OrderDAOImpl;
public class OrderServiceImpl implements OrderService {
	
	private OrderDAO orderDAO = new OrderDAOImpl();
	
	@Override
	public void addOrder(Integer userId, List<ProductDTO> cart) {
		Integer quantity = 1; //固定數量(Homework:如何通過數量調整)
		//新增訂單主檔後可以得到 orderId
		Integer orderId = orderDAO.addOrder(userId);
		//逐一新增訂單明細
		for(ProductDTO productDTO : cart) {
			orderDAO.addOrderItem(orderId, productDTO.getProductId(), quantity);
		}
	}

	@Override
	public List<OrderDTO> findAllOrdersByUserId(Integer userId) {
		List<OrderDTO> orderDTOs = new ArrayList<>();
		List<Order> orders = orderDAO.findAllOrdersByUserId(userId);
		//取得該使用者的所有訂單資訊
		for(Order order : orders) {
			OrderDTO orderDTO  = new OrderDTO();
			orderDTO.setOrderId(order.getOrderId());
			orderDTO.setUserId(order.getUserId());
			orderDTO.setOrderDate(order.getOrderDate());
			for(OrderItem item : orderDAO.findAllOrderItemsByUserId(order.getUserId())){
				// OrderItem 轉 OrderItemDTO
				OrderItemDTO itemDTO = new OrderItemDTO();
				itemDTO.setItemId(item.getItemId());
				itemDTO.setProductId(item.getProductId());
				itemDTO.setOrderId(item.getOrderId());
				itemDTO.setQuantity(item.getQuantity());
				orderDTO.getItems().add(itemDTO);
			} 
			
		}
		return orderDTOs;
	}
	
}
