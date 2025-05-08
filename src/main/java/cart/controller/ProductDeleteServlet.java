package cart.controller;

import java.io.IOException;

import cart.service.ProductService;
import cart.service.impl.ProductServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/product/delete")
public class ProductDeleteServlet extends HttpServlet{
	
	private ProductService service = new ProductServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String productId = req.getParameter("productId");
		service.delete(Integer.parseInt(productId));
		resp.sendRedirect("/JavaWebCart/product/list");
	}
}
