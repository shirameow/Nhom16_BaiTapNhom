package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DeTaiDAO;
import DAO.NhomDAO;
import model.*;

/**
 * Servlet implementation class SubmitDuyetNhomController
 */
@WebServlet("/duyet-nhom")
public class SubmitDuyetNhomController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");

		DeTaiDAO detaiDAO = new DeTaiDAO();
		NhomDAO nhomDAO = new NhomDAO();

		int manhom = Integer.parseInt(request.getParameter("manhom"));
		int madt = Integer.parseInt(request.getParameter("madt"));
		List<NhomModel> listnhom = nhomDAO.DanhSachNhomChungDeTai(madt);
		for (NhomModel nhom : listnhom) {
			if (nhom.getMaNhom() != manhom) {
				detaiDAO.XoaDeTaiDangChoDuyet(madt, nhom.getMaNhom());
			}
		}
		detaiDAO.DuyetDeTai(manhom, madt);
		String mess = "Đã duyệt đề tài " + String.valueOf(madt) + " cho nhóm " + String.valueOf(manhom);
		request.setAttribute("mess", mess);
		request.getRequestDispatcher("quanlidetai.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
