package cart.service.impl;

import cart.dao.ProductDAO;
import cart.dao.impl.ProductDAOImpl;

import java.util.ArrayList;
import java.util.List;

import cart.model.dto.ProductDTO;
import cart.model.entity.Product;
import cart.service.ProductService;

public class ProductServiceImpl implements ProductService {
	
	private ProductDAO productDAO = new ProductDAOImpl();
	@Override
	public List<ProductDTO> findAllProducts() {
		List<Product> products = productDAO.findAllProducts();
		List<ProductDTO> productDTOs = products.stream()
		.map(product -> {
							ProductDTO productDTO = new ProductDTO();
							productDTO.setProductId(product.getProductId());
							productDTO.setProductName(product.getProductName());
							productDTO.setPrice(product.getPrice());
							productDTO.setQty(product.getQty());
							productDTO.setImageBase64(product.getImageBase64());
							productDTO.setTotal(product.getPrice()*product.getQty());
							return productDTO;
		})
		.toList();
		return productDTOs;
	}

	@Override
	public void add(String productName, String price, String qty, String productImageBase64) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String productId) {
		// TODO Auto-generated method stub

	}

}
