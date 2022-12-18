package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.BoMonDAO;
import model.GiangVienModel;
import model.SinhVienModel;
import model.accountModel;

/**
 * Servlet implementation class ThongTinTaiKhoanContronller
 */
@WebServlet("/thongtin-taikhoan")
public class ThongTinTaiKhoanContronller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");

		HttpSession session = request.getSession();
		accountModel account = new accountModel();
		account = (accountModel) session.getAttribute("account");
		
		if (!account.getRole().equals("Admin")) {
			if (account.getRole().equals("Sinh Viên")) {
				SinhVienModel sv = (SinhVienModel) session.getAttribute("Info");
				BoMonDAO dao = new BoMonDAO();
				request.setAttribute("tenbomon", dao.TimBoMonTheoMa(sv.getBoMon()));
			} else {
				GiangVienModel gv = (GiangVienModel) session.getAttribute("Info");
				BoMonDAO dao = new BoMonDAO();
				request.setAttribute("tenbomon", dao.TimBoMonTheoMa(gv.getBoMon()));
			}			
		}
		request.getRequestDispatcher("thongtintaikhoan.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
