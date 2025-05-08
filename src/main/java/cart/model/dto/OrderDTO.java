package cart.model.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cart.model.entity.OrderItem;
import lombok.Data;
@Data
public class OrderDTO  {
	private Integer orderId;
	private Integer userId;
	private Date orderDate;
	// 集合該筆訂單所有項目的集合
	private List<OrderItemDTO> items = new ArrayList<>();
}
