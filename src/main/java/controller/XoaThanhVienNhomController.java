package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.NhomDAO;
import model.SinhVienModel;


@WebServlet("/xoa-thanh-vien-nhom")
public class XoaThanhVienNhomController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		HttpSession session = request.getSession();
		SinhVienModel sinhvien = new SinhVienModel();
		sinhvien = (SinhVienModel) session.getAttribute("Info");
		
		String mssv = request.getParameter("mssv");
		NhomDAO nhomDAO = new NhomDAO();
		nhomDAO.XoaThanhVienNhom(mssv);
		String mess = "Xóa thành công";
		request.setAttribute("mess", mess);
		
		List<SinhVienModel> listSV = new ArrayList<SinhVienModel>();
		listSV = nhomDAO.DanhSachThanhVienNhom(sinhvien.getNhom());
		request.setAttribute("listThanhVienNhom", listSV);
		
		RequestDispatcher rq = request.getRequestDispatcher("thongtinnhom.jsp");
		rq.forward(request, response);	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
