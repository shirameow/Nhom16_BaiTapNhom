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
 * Servlet implementation class XoaThanhVienHDController
 */
@WebServlet("/xoa-thanh-vien-hd")
public class XoaThanhVienHDController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		String url="chitiethoidong.jsp";
		String maGV=request.getParameter("maGV");
		String messXGVHD="";
		if(new GiangVienDAO().XoaGVKhoiHD(maGV)) {
			messXGVHD="Xóa giảng viên khỏi hội đồng thành công!";
			url="thong-tin-HD";
		}
		else
			messXGVHD="Xóa giảng viên khỏi hội đồng thất bại";
		
		request.setAttribute("messXGVHD",messXGVHD);
		request.getRequestDispatcher(url).forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
