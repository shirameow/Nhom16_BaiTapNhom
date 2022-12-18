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

import model.*;
import DAO.*;
/**
 * Servlet implementation class TrangGiangVienPhanBienController
 */
@WebServlet("/giang-vien-phan-bien")
public class TrangGiangVienPhanBienController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		HttpSession ses=request.getSession();
		GiangVienModel gv=(GiangVienModel)ses.getAttribute("Info");
		List<DeTaiModel> listdetai=new DeTaiDAO().DanhSachDeTaiTheoBoMon(gv.getBoMon());
		
		List<PhanBienModel> listphanbien = new ArrayList<PhanBienModel>();
		for(DeTaiModel detai : listdetai) {
			GiangVienModel giangvien = new PhanBienDAO().GiangVienDangPhanBien(detai.getMaDeTai());
			if(giangvien!=null)
				listphanbien.add(new PhanBienModel(detai, giangvien));
			else
				listphanbien.add(new PhanBienModel(detai));
		}
		List<GiangVienModel>listgiangvien=new GiangVienDAO().DanhSachGiangVienTheoBoMon(gv.getBoMon());
		
		request.setAttribute("listphanbien", listphanbien);
		request.setAttribute("listgv", listgiangvien);
		request.getRequestDispatcher("phanbien.jsp").forward(request, response);
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
