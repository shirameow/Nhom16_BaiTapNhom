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
@WebServlet("/them-sinh-vien")
public class ThemSinhVienConttroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		List<BoMonModel> listBM=new BoMonDAO().getAllBoMon();
		List<accountModel>listACCN=new AccountDAO().getAllAccountNoneUser();
		HttpSession ses=request.getSession();
		ses.setAttribute("listBM", listBM);
		ses.setAttribute("listACCN", listACCN);
		
		request.getRequestDispatcher("themsinhvien.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
