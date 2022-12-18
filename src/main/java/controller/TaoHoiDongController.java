package controller;

import java.io.IOException;
import DAO.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;

@WebServlet("/tao-hoi-dong")
public class TaoHoiDongController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		String url="thongtinhoidong.jsp";
		String maHD=request.getParameter("MaHD");
		String tenHD=request.getParameter("TenHD");
		HoiDongModel hd=new HoiDongModel(maHD,tenHD);
		String messHD="";
		if(new HoiDongDAO().taoHoiDong(hd)) {
			messHD="Tạo hội đồng thành công!";
			url="hoi-dong";
		}
		else
			messHD="Tạo hội đồng thất bại";
		
		request.setAttribute("messHD",messHD);
		request.getRequestDispatcher(url).forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
