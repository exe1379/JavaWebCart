package cart.filter;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebFilter(urlPatterns = {"/user/list", "/product/list"})
public class LoginFilter extends HttpFilter{

	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpSession session = request.getSession();
		// 根據 session 是否有userDTO 物件來判斷是否已登入
		if(session.getAttribute("userDTO") == null) {
			// 若使用者不存在，重導到登入頁面
			response.sendRedirect("/JavaWebCart/user/login");
		}else {
			// 使用者存在則bypass
			chain.doFilter(request, response);
		}
	}

}
