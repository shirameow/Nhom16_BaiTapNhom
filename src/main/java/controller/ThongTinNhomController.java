package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.*;
import DAO.NhomDAO;

/**
 * Servlet implementation class ThongTinNhomController
 */
@WebServlet("/thongtin-nhom")
public class ThongTinNhomController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		HttpSession session=request.getSession();
		SinhVienModel sinhvien = new SinhVienModel();
		sinhvien = (SinhVienModel)session.getAttribute("Info");
		
		NhomDAO nhomDAO = new NhomDAO();
		if(sinhvien.getNhom() !=0) {
			List<SinhVienModel> listSV = new ArrayList<SinhVienModel>();
			listSV = nhomDAO.DanhSachThanhVienNhom(sinhvien.getNhom());
			request.setAttribute("listThanhVienNhom", listSV);
			
			NhomModel nhom = nhomDAO.ThongTinNhom(sinhvien.getNhom());
			request.setAttribute("nhom", nhom);
		}else {
			List<NhomModel> listNhom = nhomDAO.DanhSachNhomTheoBoMon(sinhvien.getBoMon());
			request.setAttribute("listNhom", listNhom);
		}
		
		request.getRequestDispatcher("thongtinnhom.jsp").forward(request, response);
	}

}
