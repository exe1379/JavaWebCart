package cart.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	private Integer productId;
	private String productName;
	private Integer price;
	private Integer qty;
	private String imageBase64;
}
