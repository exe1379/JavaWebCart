package cart.controller;

import cart.model.dto.UserDTO;
import cart.service.UserListService;
import cart.service.impl.UserListServiceImpl;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/user/list")
public class UserListServlet extends HttpServlet{
	
	private UserListService service = new UserListServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<UserDTO> userDTOs = service.findAllUsers();
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/cart/user_list.jsp");
		req.setAttribute("userDTOs", userDTOs);
		rd.forward(req, resp);
	}
}
