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

import model.DeTaiModel;
import model.SinhVienModel;
import model.DeTaiGVModel;
import DAO.*;

/**
 * Servlet implementation class TrangDangKyDeTaiSVController
 */
@WebServlet("/trang-dang-ky-de-tai-sinh-vien")
public class TrangDangKyDeTaiSVController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");

		HttpSession session = request.getSession();
		SinhVienModel sinhvien = new SinhVienModel();
		sinhvien = (SinhVienModel) session.getAttribute("Info");
		
		GiangVienDAO gvDAO = new GiangVienDAO();
		DeTaiDAO dtDAO = new DeTaiDAO();
		DeTaiModel detaicuanhom = dtDAO.DeTaiCuaNhomDaDuyet(sinhvien.getNhom());
		if (dtDAO.KiemTraTrangThaiDangKySV() == 1) {
			request.setAttribute("modangky", 1);
			if (detaicuanhom == null) {
				request.setAttribute("daduyet", 0);
				List<DeTaiModel> o_listDeTaiTrongBoMon = dtDAO.DanhSachDeTaiTheoBoMon(sinhvien.getBoMon());
				List<DeTaiGVModel> listDeTaiTrongBoMon = new ArrayList<DeTaiGVModel>();
				for(DeTaiModel detai : o_listDeTaiTrongBoMon) {
					listDeTaiTrongBoMon.add(new DeTaiGVModel(detai.getMaDeTai(), detai.getTenDeTai(), gvDAO.TimGiangVienTheoMaGV(detai.getGiangVien())));
				}
				request.setAttribute("listDeTaiTrongBoMon", listDeTaiTrongBoMon);
				if (sinhvien.getNhom() != 0) {
					List<DeTaiModel> o_listDeTaiCuaNhom = dtDAO.DanhSachDeTaiSVDaDK(sinhvien.getNhom());
					List<DeTaiGVModel> listDeTaiCuaNhom = new ArrayList<DeTaiGVModel>();
					for(DeTaiModel detai : o_listDeTaiCuaNhom) {
						listDeTaiCuaNhom.add(new DeTaiGVModel(detai.getMaDeTai(), detai.getTenDeTai(), gvDAO.TimGiangVienTheoMaGV(detai.getGiangVien())));
					}
					request.setAttribute("listDeTaiCuaNhom", listDeTaiCuaNhom);
				}
			} else {
				request.setAttribute("daduyet", 1);
				String tengv = gvDAO.TimGiangVienTheoMaGV(detaicuanhom.getGiangVien()).getHoten();
				request.setAttribute("detaihientai", detaicuanhom);
				request.setAttribute("tengv", tengv);
			}
		} else {
			request.setAttribute("modangky", 0);
		}
		List<DeTaiModel> o_listDeTai = dtDAO.ToanBoDanhSachDeTai();
		List<DeTaiGVModel> listDeTai = new ArrayList<DeTaiGVModel>();
		for(DeTaiModel detai : o_listDeTai) {
			listDeTai.add(new DeTaiGVModel(detai.getMaDeTai(), detai.getTenDeTai(), gvDAO.TimGiangVienTheoMaGV(detai.getGiangVien())));
		}
		request.setAttribute("listDeTai", listDeTai);

		request.getRequestDispatcher("dangkydetaisinhvien.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
