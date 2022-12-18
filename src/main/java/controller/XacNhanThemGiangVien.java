package controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.SinhVienDAO;
import model.SinhVienModel;
import model.*;
import DAO.*;

@WebServlet("/xac-nhan-themGV")
public class XacNhanThemGiangVien extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");

		String msgv = request.getParameter("Id");
		String hoten = request.getParameter("HoTen");
		String bomon = request.getParameter("bomon");
		String truongbomon = request.getParameter("truongBM");
		int truongBM = Integer.parseInt(truongbomon);
		ServletContext sc = getServletContext();
		accountModel newacc = (accountModel) sc.getAttribute("newACC");
		String taikhoan = newacc.getUsername();
		GiangVienModel gv = new GiangVienModel(msgv, hoten, taikhoan, bomon, null, truongBM);
		String messTSV = "";
		if (new GiangVienDAO().themGiangVien(gv)) {
			messTSV = "Thêm giảng viên thành công";
			sc.removeAttribute("newACC");
			request.setAttribute("messXTK", messTSV);
			request.getRequestDispatcher("quanli-taikhoan").forward(request, response);
		} else {
			messTSV = "Thêm giảng viên thất bại";

			request.setAttribute("messTSV", messTSV);
			request.getRequestDispatcher("themgiangvien.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
