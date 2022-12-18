package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.*;
import model.*;
/**
 * Servlet implementation class XoaHoiDongController
 */
@WebServlet("/xoa-hoi-dong")
public class XoaHoiDongController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		
		String url="quanlihoidong.jsp";
		
		String maHD=request.getParameter("maHD");
		
		String messXHD="";
		if(new HoiDongDAO().XoaHD(maHD)) {
			messXHD="Xóa thành công";
			url="hoi-dong";
		}
		else
			messXHD="Xóa thất bại";
		
		request.setAttribute("messXHD", messXHD);
		request.getRequestDispatcher(url).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
