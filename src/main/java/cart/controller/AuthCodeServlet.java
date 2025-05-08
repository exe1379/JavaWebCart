package cart.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/user/authcode")
public class AuthCodeServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Random random = new Random();
		String authcode = String.format("%04d", random.nextInt(10000));//%04d:不足四位數時自動補上0
		//將authcode存入 HttpSession 中
		HttpSession session = req.getSession();
		session.setAttribute("authcode", authcode);
		ImageIO.write(getAuthCodeImage(authcode),"JPEG" , resp.getOutputStream());
	}
	private BufferedImage getAuthCodeImage(String authcode) {
		// 建立圖像(80x30 TGB)
		BufferedImage img = new BufferedImage(80,30,BufferedImage.TYPE_INT_BGR);
		//建立畫布
		Graphics g = img.getGraphics();
		//設定顏色
		g.setColor(Color.white);
		//塗滿背景
		g.fillRect(0, 0, 80, 30);
		//設定顏色
		g.setColor(Color.black);
		//設定字型
		g.setFont(new Font("Arial", Font.BOLD , 22));
		//設定繪文字
		g.drawString(authcode, 18, 22); //產生文字的起點
		g.setColor(Color.red);
		Random random = new Random();
		// 畫干擾線
		for(int i = 0; i<3 ; i++) {
			int x1 = random.nextInt(80);
			int y1 = random.nextInt(30);
			int x2 = random.nextInt(80);
			int y2 = random.nextInt(30);
			g.drawLine(x1, y1, x2, y2);
		}
		return img;
	}
}
