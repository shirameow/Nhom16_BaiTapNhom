package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DeTaiDAO;
import model.DeTaiModel;
import model.SinhVienModel;

/**
 * Servlet implementation class ThemDangKyDeTaiSVController
 */
@WebServlet("/them-dang-ky-de-tai")
public class ThemDangKyDeTaiSVController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");

		HttpSession session = request.getSession();
		SinhVienModel sinhvien = new SinhVienModel();
		sinhvien = (SinhVienModel) session.getAttribute("Info");

		int madt = Integer.parseInt(request.getParameter("madt"));
		DeTaiDAO dtDAO = new DeTaiDAO();
		String mess = "";
		if (dtDAO.KiemTraDeTaiNhomDaDangKy(madt, sinhvien.getNhom()) == 0) {
			if (dtDAO.KiemTraDeTaiDaDuocGiaoChoNhomKhac(madt) == 0) {
				dtDAO.ThemDangKyDeTai(madt, sinhvien.getNhom());
				mess = "Đăng ký thành công";
			} else {
				mess = "Đề tài này đã được giao cho nhóm khác";
			}
		} else {
			mess = "Nhóm bạn đã đăng kí đề tài này rồi";
		}
		request.setAttribute("modangky", dtDAO.KiemTraTrangThaiDangKySV());
		request.setAttribute("mess", mess);

		request.getRequestDispatcher("trang-dang-ky-de-tai-sinh-vien").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
