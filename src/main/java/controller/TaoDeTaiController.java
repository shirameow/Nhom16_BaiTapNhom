package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.*;
import DAO.*;

/**
 * Servlet implementation class TaoDeTaiController
 */
@WebServlet("/tao-de-tai")
public class TaoDeTaiController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");

		HttpSession session = request.getSession();
		accountModel acc = new accountModel();
		acc = (accountModel) session.getAttribute("account");
		GiangVienModel gv = new GiangVienModel();
		gv = new ThongtintaikhoanDAO().ThongTinGV(acc.getUsername());
		String TenDeTai = request.getParameter("tendt");
		String GiangVien = gv.getId();
		String messTDT = "";

//		if (ddk.getTrangThai() == 1) {
		if (TenDeTai != "") {
			if (new DeTaiDAO().TaoDeTai(TenDeTai, GiangVien)) {
				messTDT = "Tạo đề tài thành công";
			} else
				messTDT = "Tạo đề tài thất bại";
		} else {
			messTDT = "Không được để trống tên đề tài";
		}
		request.setAttribute("messTDT", messTDT);
		// }
		request.getRequestDispatcher("thongtin-detai").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
