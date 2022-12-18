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
import DAO.ThongtintaikhoanDAO;

/**
 * Servlet implementation class SubmitDangkyNhomController
 */
@WebServlet("/dang-ky-nhom")
public class SubmitDangkyNhomController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");

		HttpSession session = request.getSession();
		SinhVienModel sinhvien = new SinhVienModel();
		sinhvien = (SinhVienModel) session.getAttribute("Info");
		
		String mess = "";
		NhomDAO nhomDAO = new NhomDAO();
		
		String tenNhom = request.getParameter("tenNhom");
		String lienHe = request. getParameter("lienHe");
		
		if(nhomDAO.LayMaNhomTheoTenNhom(tenNhom)==0) {
			nhomDAO.DangKyNhom(tenNhom, sinhvien.getBoMon(), lienHe, sinhvien.getId());
			mess = "Đăng kí nhóm thành công";
			
			ThongtintaikhoanDAO thongtin = new ThongtintaikhoanDAO();
			String tk = sinhvien.getTaiKhoan();
			sinhvien = thongtin.ThongTinSV(tk);
			session.setAttribute("Info", sinhvien);
			request.setAttribute("mess", mess);
			
			List<SinhVienModel> listSV = new ArrayList<SinhVienModel>();
			listSV = nhomDAO.DanhSachThanhVienNhom(sinhvien.getNhom());
			request.setAttribute("listThanhVienNhom", listSV);
			
			RequestDispatcher rq = request.getRequestDispatcher("thongtinnhom.jsp");
			rq.forward(request, response);
		} else {
			mess = "Tên nhóm đã tồn tại, vui lòng nhập tên nhóm khác";
			
			request.setAttribute("mess", mess);
			RequestDispatcher rq = request.getRequestDispatcher("dangkynhom.jsp");
			rq.forward(request, response);
		}
	}

}
