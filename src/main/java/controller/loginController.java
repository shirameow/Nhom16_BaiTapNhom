package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.loginDAO;
import model.*;
import DAO.ThongtintaikhoanDAO;
/**
 * Servlet implementation class loginController
 */
@WebServlet(urlPatterns={"/dang-nhap"})
public class loginController extends HttpServlet {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user= request.getParameter("Email");
		String password= request.getParameter("Password");
		loginDAO check = new loginDAO();
		accountModel account=check.getAccount(user, password);
		
		if(account!=null) {
			HttpSession session=request.getSession();
			session.setAttribute("account", account);
			
			ThongtintaikhoanDAO thongtin = new ThongtintaikhoanDAO();
			if(account.getRole().equals("Sinh Viên")) {
				SinhVienModel sv=new SinhVienModel();
				sv = thongtin.ThongTinSV(account.getUsername());
				session.setAttribute("Info", sv);
			}
			else if(account.getRole().equals("Giảng Viên")) {
				GiangVienModel gv=new GiangVienModel();
				gv = thongtin.ThongTinGV(account.getUsername());
				session.setAttribute("Info", gv);
			}
			else if(account.getRole().equals("Admin")) {
				AdminModel ad=new AdminModel();
				ad = thongtin.ThongTinAd(account.getUsername());
				session.setAttribute("Info", ad);
			}
			RequestDispatcher rq= request.getRequestDispatcher("home.jsp");
			rq.forward(request, response);	
		}
		else {
			String mess="Tài Khoản hoặc Mật Khẩu Không chính xác!";
			request.setAttribute("mess",mess);
			RequestDispatcher rq= request.getRequestDispatcher("index.jsp");
			rq.forward(request, response);	
		}
		
	}

}
