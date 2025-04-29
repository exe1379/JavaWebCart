package cart.dao;

import java.util.List;

import cart.model.entity.Product;

public interface ProductDAO {
	
	List<Product> findAllProducts(); //查詢全部product
	
	void add(Product product); //新增一筆product
	
	void delete(Integer productId); //根據productId刪除product
}
