package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.*;
import DAO.*;

/**
 * Servlet implementation class DoiMKController
 */
@WebServlet("/doi-mat-khau")
public class DoiMKController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");

		String oldpw = request.getParameter("oldpw");
		String newpw = request.getParameter("newpw");
		String confirmpw = request.getParameter("cfpw");
		HttpSession session = request.getSession();
		accountModel acc = new accountModel();
		acc = (accountModel) session.getAttribute("account");
		AccountDAO accdao = new AccountDAO();
		String messDMK = "";
		if (oldpw.equals(acc.getPassword())) {
			if (newpw.equals(confirmpw)) {
				accdao.DoiMK(acc.getUsername(), newpw);
				acc.setPassword(newpw);
				session.setAttribute("account", acc);
				messDMK = "Đổi mật khẩu thành công";
			} else {
				messDMK = "Xác nhận mật khẩu mới không thành công!";
			}

		} else {
			messDMK = "Mật khẩu không chính xác!";
		}
		session.setAttribute("messDMK", messDMK);
		request.getRequestDispatcher("thongtintaikhoan.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
