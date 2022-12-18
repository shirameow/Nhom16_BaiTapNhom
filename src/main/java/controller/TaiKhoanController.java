package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.AccountDAO;
import model.*;
import DAO.*;

@WebServlet("/xem-thong-tin-tai-khoan-Admin")
public class TaiKhoanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		String taiKhoan=request.getParameter("Username");
		AccountDAO accdao=new AccountDAO();
		ThongtintaikhoanDAO tttkDAO=new ThongtintaikhoanDAO();
		Object tttk=new Object();
		
		if(accdao.checkRole(taiKhoan)==1)
			tttk= tttkDAO.ThongTinSV(taiKhoan);
		else if(accdao.checkRole(taiKhoan)==2)
			tttk=tttkDAO.ThongTinGV(taiKhoan);
		else if(accdao.checkRole(taiKhoan)==3)
			tttk=tttkDAO.ThongTinAd(taiKhoan);
		request.setAttribute("Info", tttk);
		request.getRequestDispatcher("thongtintaikhoan.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
