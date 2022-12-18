package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.NhomDAO;
import DAO.ThongtintaikhoanDAO;
import model.SinhVienModel;

/**
 * Servlet implementation class ThemThanhVienNhomController
 */
@WebServlet("/them-thanh-vien")
public class SubmitThemThanhVienNhomController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");

		HttpSession session = request.getSession();
		SinhVienModel sinhvien = new SinhVienModel();
		sinhvien = (SinhVienModel) session.getAttribute("Info");

		String mess = "";
		NhomDAO nhomDAO = new NhomDAO();
		ThongtintaikhoanDAO tkDAO = new ThongtintaikhoanDAO();
		String newMSSV = request.getParameter("maSV");

		SinhVienModel newSV = tkDAO.ThongTinSinhVienTheoMSSV(newMSSV);

		if (newSV != null) {
			if (newSV.getBoMon().equals(sinhvien.getBoMon())) {
				if (nhomDAO.KiemTraNhom(newMSSV) == 0) {
					nhomDAO.ThemThanhVienNhom(sinhvien.getNhom(), newMSSV);
					mess = "Đã thêm thành viên có mã " + newMSSV;
				} else {
					mess = "Người này đã có nhóm";
				}
			} else {
				mess = "Sinh viên này không cùng chuyên ngành với nhóm bạn";
			}
		} else {
			mess = "Không tìm thấy sinh viên có mã số " + newMSSV;
		}
		request.setAttribute("mess", mess);
		RequestDispatcher rq = request.getRequestDispatcher("themthanhviennhom.jsp");
		rq.forward(request, response);

	}

}
