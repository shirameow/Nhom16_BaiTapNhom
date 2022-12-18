package controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.AdminDAO;
import model.AdminModel;
import model.accountModel;

/**
 * Servlet implementation class XacNhanThemAdmin
 */
@WebServlet("/xac-nhan-them-Admin")
public class XacNhanThemAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		
		String id = request.getParameter("Id");
		String hoten = request.getParameter("HoTen");
		ServletContext sc=getServletContext();
		accountModel newacc=(accountModel)sc.getAttribute("newACC");
		String taikhoan=newacc.getUsername();
		AdminModel ad = new AdminModel(id, hoten,taikhoan);
		String messTSV = "";
		if (new AdminDAO().themAdmin(ad)) {
			messTSV = "Thêm Admin thành công";
		} else
			messTSV = "Thêm Admin thất bại";
		sc.removeAttribute("newACC");
		request.setAttribute("messTSV", messTSV);
		request.getRequestDispatcher("themadmin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
