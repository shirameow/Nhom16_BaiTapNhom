package controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;
import DAO.*;

@WebServlet("/xac-nhan-themSV")
public class XacNhanThemSV extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");

		String mssv = request.getParameter("Id");
		String hoten = request.getParameter("HoTen");
		String bomon = request.getParameter("bomon");

		ServletContext sc = getServletContext();
		accountModel newacc = (accountModel) sc.getAttribute("newACC");
		String taikhoan = newacc.getUsername();
		SinhVienModel sv = new SinhVienModel(mssv, hoten, bomon, taikhoan, 0, 0);
		String messTSV = "";
		if (new SinhVienDAO().themSinhVien(sv)) {
			messTSV = "Thêm sinh viên thành công";
			sc.removeAttribute("newACC");
			request.setAttribute("messXTK", messTSV);
			request.getRequestDispatcher("quanli-taikhoan").forward(request, response);
		} else {
			messTSV = "Thêm sinh viên thất bại";

			request.setAttribute("messTSV", messTSV);
			request.getRequestDispatcher("themsinhvien.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
