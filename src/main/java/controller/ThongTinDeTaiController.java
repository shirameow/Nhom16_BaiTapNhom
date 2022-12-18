package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.*;
import model.*;
/**
 * Servlet implementation class ThongTinDeTaiController
 */
@WebServlet("/thongtin-detai")
public class ThongTinDeTaiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		HttpSession ses=request.getSession();
		GiangVienModel gv=(GiangVienModel)( ses.getAttribute("Info"));
		String boMon=gv.getBoMon();
		DeTaiDAO dtDAO=new DeTaiDAO();
		GiangVienDAO gvDAO = new GiangVienDAO();
		
		List<DeTaiModel> o_listDT=dtDAO.getDeTaiTheoBoMon(boMon);
		List<DeTaiGVModel> listDT = new ArrayList<DeTaiGVModel>();
		for(DeTaiModel detai : o_listDT) {
			listDT.add(new DeTaiGVModel(detai.getMaDeTai(), detai.getTenDeTai(), gvDAO.TimGiangVienTheoMaGV(detai.getGiangVien())));
		}
		
		List<DotDangKiModel> listDDK = new DotDangKiDAO().getDotDK();
		DotDangKiModel ddk = listDDK.get(0);
		ses.setAttribute("trangthaiDK", ddk.getTrangThai());
		
		ses.setAttribute("listDT", listDT);
		request.getRequestDispatcher("taodetai.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
