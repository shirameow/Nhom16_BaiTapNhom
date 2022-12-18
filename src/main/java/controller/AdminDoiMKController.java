package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.AccountDAO;
import model.accountModel;

@WebServlet("/admin-doi-mat-khau")
public class AdminDoiMKController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");

		String oldpw = request.getParameter("oldpw");
		String newpw = request.getParameter("newpw");
		String confirmpw = request.getParameter("cfpw");
		HttpSession ses=request.getSession();
		accountModel accAdminXem = new accountModel();
		accAdminXem=(accountModel)ses.getAttribute("accAdminXem");
		
		
		AccountDAO accdao = new AccountDAO();
		String messDMK = "";

		if (oldpw.equals(accAdminXem.getPassword())) {
			if (newpw.equals(confirmpw)) {
				accdao.DoiMK(accAdminXem.getUsername(), newpw);
				accAdminXem.setPassword(newpw);				
				messDMK = "Đổi mật khẩu thành công";
			} else {
				messDMK = "Xác nhận mật khẩu mới không thành công!";
			}

		} else {
			messDMK = "Mật khẩu không chính xác!";
		}
		request.setAttribute("messDMK", messDMK);
		request.getRequestDispatcher("thongtintaikhoanadminxem.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
