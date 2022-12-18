package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DeTaiDAO;
import model.*;

/**
 * Servlet implementation class QuanLyDeTaiController
 */
@WebServlet("/quanly-detai")
public class QuanLyDeTaiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");

		HttpSession session = request.getSession();
		GiangVienModel giangvien = (GiangVienModel) session.getAttribute("Info");
		DeTaiDAO detaiDAO = new DeTaiDAO();
		List<DeTaiModel> listDeTai = detaiDAO.getDeTaiCaNhanGV(giangvien.getId());
		
		request.setAttribute("listdetai", listDeTai);
		request.getRequestDispatcher("quanlidetai.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
