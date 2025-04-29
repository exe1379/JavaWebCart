package cart.service;

import java.util.List;

import cart.model.dto.ProductDTO;
import cart.model.entity.Product;

public interface ProductService {
	
	List<ProductDTO> findAllProducts(); //查詢全部product
	// 根據傳入資料新增一筆 product
	void add(String productName, String price, String qty, String productImageBase64); 
	
	void delete(String productId); //根據productId刪除product
}
