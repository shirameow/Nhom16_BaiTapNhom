package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;
import DAO.*
;/**
 * Servlet implementation class XacNhanGiangVienPhanBien
 */
@WebServlet("/xac-nhan-giang-vien-phan-bien")
public class XacNhanGiangVienPhanBien extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		String madtai=request.getParameter("madt");
		int madt=Integer.parseInt(madtai);
		String gv=request.getParameter("giangvien");
		PhanBienDAO pbDAO=new PhanBienDAO();
		String mess=null;
		GiangVienModel giangviendangphanbienhientai=pbDAO.GiangVienDangPhanBien(madt);
		String url="phanbien.jsp";
		if(giangviendangphanbienhientai!=null) {
			if(pbDAO.ThayGiangVienPhanVien(madt, gv)) {
				mess="Cập nhật giảng viên phản biện cho đề tài này thành công!";
				url="giang-vien-phan-bien";
			}
			else 
				mess="Cập nhật giảng viên phản biệt cho đề tài này thất bại!";
		}
		else {
			if(pbDAO.ThemGiangVienPhanVien(madt, gv)) {
				mess="Cập nhật giảng viên phản biện cho đề tài này thành công!";
				url="giang-vien-phan-bien";
			}
			else
				mess="Cập nhật giảng viên phản biệt cho đề tài này thất bại!";
		}
		request.setAttribute("mess", mess);
		request.getRequestDispatcher(url).forward(request, response);
		System.out.print(gv);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
