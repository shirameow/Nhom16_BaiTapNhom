package controller;
import DAO.loginDAO;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.loginDAO;
import model.accountModel;
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
		String role=request.getParameter("role");
		loginDAO check = new loginDAO();
		accountModel account=check.getAccount(user, password);
		System.out.println(account.getUsername());
		System.out.println(account.getRole());
		if(account!=null) {
			HttpSession session=request.getSession();
			session.setAttribute("account", account);
			RequestDispatcher rq= request.getRequestDispatcher("home.jsp");
			rq.forward(request, response);
			
		}
	}

}
