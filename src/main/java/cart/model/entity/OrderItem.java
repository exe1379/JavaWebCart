package cart.model.entity;

import lombok.Data;

@Data
public class OrderItem {
	private Integer itemId;
	private Integer orderId;
	private Integer productId;
	private Integer quantity;
	// 可加上訂單的 price 屬性 (商品價格可能會變動)
}
