package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.*;
import model.*;

@WebServlet("/thong-tin-HD")
public class ThongTinHoiDongController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		String maHD=request.getParameter("MaHD");
		String tenHD=request.getParameter("tenHD");
		HoiDongModel hd=new HoiDongModel(maHD,tenHD);
		List<ThongTinHDModel> listGVHD=new HoiDongDAO().getThongTinHD(hd);
		
		HttpSession ses=request.getSession();
		ses.setAttribute("listGVHD",listGVHD);
		ses.setAttribute("maHD", maHD);
		
		request.getRequestDispatcher("chitiethoidong.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
