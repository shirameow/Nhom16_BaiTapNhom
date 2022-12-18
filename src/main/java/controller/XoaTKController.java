package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;
import DAO.*;
/**
 * Servlet implementation class XoaTKController
 */
@WebServlet("/xoa-tk")
public class XoaTKController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		String username=request.getParameter("Username");
		String messXTK="";
		String url="quanlitaikhoan.jsp";
		if(new AccountDAO().XoaTK(username)) {
			messXTK="Xóa Tài Khoản Thành Công";
			url="quanli-taikhoan";
		}
		else {
			messXTK="Xóa Tài Khoản Thất Bại";}
		request.setAttribute("messXTK", messXTK);
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
