package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.*;
import model.*;

@WebServlet("/dong-mo-DK")
public class DongMoDKController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		String url="quanlidotDK.jsp";
		String nhomNguoi=request.getParameter("NhomNguoi");
		int trangThai=Integer.parseInt(request.getParameter("TrangThai"));
		DotDangKiModel ddk=new DotDangKiModel(nhomNguoi,trangThai);
		
		String messDDK="";
		if(new DotDangKiDAO().ThayDoiTrangThaiDDK(ddk)) {
			url="quan-li-DDK";
			messDDK="Thay đổi trạng thái thành công";
		}
		else
			messDDK="Thay đổi trạng thái thất bại";
		
		request.setAttribute("messDDK", messDDK);
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
