package cart.model.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
	// 對應entity.product 欄位
	private Integer productId;
	private String productName;
	private Integer price;
	private Integer qty;
	private String imageBase64;
	// 自訂欄位 total = price*qty
	private Integer total;
}
