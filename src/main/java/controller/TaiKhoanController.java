package controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.*;
import DAO.*;

@WebServlet("/xem-thong-tin-tai-khoan-Admin")
public class TaiKhoanController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");

		String taiKhoan = request.getParameter("Username");
		AccountDAO accdao = new AccountDAO();
		ThongtintaikhoanDAO tttkDAO = new ThongtintaikhoanDAO();
		/* Object tttk = new Object(); */
		HttpSession ses = request.getSession();
		accountModel accAdminXem = new AccountDAO().getAccountWithUsername(taiKhoan);
		ses.setAttribute("accAdminXem", accAdminXem);

		if (accdao.checkRole(taiKhoan) == 1) {
			SinhVienModel tttk = tttkDAO.ThongTinSV(taiKhoan);
			BoMonDAO dao = new BoMonDAO();
			request.setAttribute("tenbomon", dao.TimBoMonTheoMa(tttk.getBoMon()));
			ses.setAttribute("InfoTKADXem", tttk);
		} else if (accdao.checkRole(taiKhoan) == 2) {
			GiangVienModel tttk = tttkDAO.ThongTinGV(taiKhoan);
			BoMonDAO dao = new BoMonDAO();
			request.setAttribute("tenbomon", dao.TimBoMonTheoMa(tttk.getBoMon()));
			ses.setAttribute("InfoTKADXem", tttk);
		} else if (accdao.checkRole(taiKhoan) == 3) {
			AdminModel tttk = tttkDAO.ThongTinAd(taiKhoan);
			ses.setAttribute("InfoTKADXem", tttk);
		}
		/* ses.setAttribute("InfoTKADXem", tttk); */

		request.getRequestDispatcher("thongtintaikhoanadminxem.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
