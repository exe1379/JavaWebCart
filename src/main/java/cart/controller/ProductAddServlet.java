package cart.controller;

import java.io.IOException;
import java.util.Base64;

import cart.service.ProductService;
import cart.service.impl.ProductServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
// 上傳檔案要加@MultipartConfig
@MultipartConfig
@WebServlet("/product/add")
public class ProductAddServlet extends HttpServlet{

	private ProductService service = new ProductServiceImpl();
		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//接收一般表單資料
	String productName = req.getParameter("productName");
	String price = req.getParameter("price");
	String qty = req.getParameter("qty");
	//接收上傳檔案資料
	Part productImage = req.getPart("productImage");
	//將 Part 物件轉 -> byte[] -> 轉字串 -> 再存入資料表
	byte[] bytes = productImage.getInputStream().readAllBytes();
	String productImageBase64 = Base64.getEncoder().encodeToString(bytes);
	service.add(productName, price, qty, productImageBase64);
	//重導到result.jsp
	String message = String.format("商品新增成功<p/>商品名稱：%s<p/>商品價格：%s<p/>商品庫存：%s<p/>商品照片：<img src='data:image/png;base64,%s'><p/>", 
			productName, price, qty, productImageBase64);
	req.setAttribute("resultTitle", "商品新增");
	req.setAttribute("resultMessage", message);
	req.getRequestDispatcher("/WEB-INF/view/cart/result.jsp").forward(req, resp);
	}
}
