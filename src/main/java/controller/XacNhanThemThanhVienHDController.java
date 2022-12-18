package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.*;
import DAO.*;
/**
 * Servlet implementation class XacNhanThemThanhVienHDController
 */
@WebServlet("/xac-nhan-them-thanh-vien-HD")
public class XacNhanThemThanhVienHDController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		HttpSession ses=request.getSession();
		String maHD=String.valueOf(ses.getAttribute("maHD"));
		String gv=request.getParameter("giangvien");
		String url="themthanhvienhoidong.jsp";
		String messTGV="";
		if(new GiangVienDAO().themGVVaoHD(maHD, gv)) {
			messTGV="Thêm giảng viên vào hội đồng thành công";
			url="them-thanh-vien-HD";
		}
		else 
			messTGV="Thêm giảng viên vào hội đồng thất bại";
		request.setAttribute("messTGV",messTGV);
		request.getRequestDispatcher(url).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
