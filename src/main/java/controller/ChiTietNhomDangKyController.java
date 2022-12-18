package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.NhomDAO;
import model.NhomModel;
import model.SinhVienModel;

/**
 * Servlet implementation class ChiTietNhomDangKyController
 */
@WebServlet("/xem-chi-tiet-nhom")
public class ChiTietNhomDangKyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		int manhom = Integer.parseInt(request.getParameter("manhom"));
		
		NhomDAO nhomDAO = new NhomDAO();
		
		List<SinhVienModel> listSV = new ArrayList<SinhVienModel>();
		listSV = nhomDAO.DanhSachThanhVienNhom(manhom);
		request.setAttribute("listThanhVienNhom", listSV);
		
		NhomModel nhom = nhomDAO.ThongTinNhom(manhom);
		request.setAttribute("nhom", nhom);
		
		request.getRequestDispatcher("chitietnhomdangky.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
