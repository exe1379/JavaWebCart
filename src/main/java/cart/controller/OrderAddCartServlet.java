package cart.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import cart.model.dto.ProductDTO;
import cart.service.ProductService;
import cart.service.impl.ProductServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/product/order/cart/add")
public class OrderAddCartServlet extends HttpServlet{

	private ProductService service = new ProductServiceImpl();
		
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		List<ProductDTO> cart = null;
		// 判斷 session 內有沒有 cart ， 若沒有則建立一個新的 cart
		if(session.getAttribute("cart") == null) {
			cart = new ArrayList<>();
		// 若有 cart 則從
		}else {
			cart = (List<ProductDTO>)session.getAttribute("cart");
		}
		// 得到要購買的商品id
		Integer productId = Integer.parseInt(req.getParameter("productId"));
		// 根據 productId 產生 productDTO
		Optional<ProductDTO> optProductDTO = service.findAllProducts()
		.stream()
		.filter(dto -> dto.getProductId().equals(productId))
		.findFirst();
		if(optProductDTO.isPresent()) {
			cart.add(optProductDTO.get());
			session.setAttribute("cart", cart);
		}
		resp.sendRedirect("/JavaWebCart/product/order");
	}
}
