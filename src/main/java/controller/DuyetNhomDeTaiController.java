package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.GiangVienModel;
import model.NhomModel;
import DAO.*;

/**
 * Servlet implementation class DuyetNhomDeTaiController
 */
@WebServlet("/duyet-nhom-de-tai")
public class DuyetNhomDeTaiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");

		NhomDAO nhomDAO = new NhomDAO();
		DeTaiDAO detaiDAO = new DeTaiDAO();
		
		int madt = Integer.parseInt(request.getParameter("MaDT"));
		List<NhomModel> listNhom = nhomDAO.DanhSachNhomChungDeTai(madt);
		
		if(detaiDAO.KiemTraTinhTrangGiaoDeTai(madt)) {
			request.setAttribute("trangthai", 1);
		} else {
			request.setAttribute("trangthai", 0);
		}
		
		request.setAttribute("listnhom", listNhom);
		request.setAttribute("madt", madt);
		
		request.getRequestDispatcher("duyetdetainhom.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
