package cart.controller;

import java.io.IOException;
import cart.service.UserRegisterService;
import cart.service.impl.UserRegisterServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//接收使用者於信件中按下的確認連結
//http://localhost:8080/JavaWebCart/email/confirm?username=
@WebServlet("/email/confirm")
public class EmailConfirmServlet extends HttpServlet{
	
	private UserRegisterService userRegisterService = new UserRegisterServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//得到username
		String username = req.getParameter("username");
	//驗證email(會修改 user 資料表中completed 欄位的資訊!!!)
		userRegisterService.emailConfirmOK(username);
	//準備給result.jsp的資訊
		String resultTitle = "email驗證結果";
		String resultMessage = "用戶名稱" + username + "<p/> email驗證成功";
		req.setAttribute("resultTitle", resultTitle);
		req.setAttribute("resultMessage", resultMessage);
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/cart/result.jsp");
		rd.forward(req, resp);
	}
	
	
}
