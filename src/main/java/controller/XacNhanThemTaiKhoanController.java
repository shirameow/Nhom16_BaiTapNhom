package controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.*;
import DAO.*;
/**
 * Servlet implementation class XacNhanThemTaiKhoanController
 */
@WebServlet("/xac-nhan-themtk")
public class XacNhanThemTaiKhoanController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");

		String username = request.getParameter("Username");
		String password = request.getParameter("passwd");
		String role = request.getParameter("role");
		ServletContext sc=getServletContext();
		accountModel newacc = new accountModel(username, password, role);
		
		String url="themTK.jsp"; 
		String messTTK = "";
		if (new AccountDAO().ThemTK(newacc)) {
			messTTK = "Tạo tài khoản thành công!";
			sc.setAttribute("newACC",newacc );
			
		} else {
			messTTK = "Tạo tài khoản thất bại!";
		}
		
		request.setAttribute("messTTK", messTTK);
		
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
