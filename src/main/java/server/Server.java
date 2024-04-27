package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import constant.Types;
import dao.ChiTietHoaDonServer;
import dao.ChiTietPhieuDatPhongServer;
import dao.ChiTietPhieuGoiMonServer;
import dao.ChucVuSerer;
import dao.HoaDonServer;
import dao.KhachHangServer;
import dao.LoaiDichVuServer;
import dao.LoaiPhongServer;
import dao.LoaiSanPhamServer;
import dao.NhanVienServer;
import dao.PhieuDatPhongServer;
import dao.PhieuGoiMonServer;
import dao.PhongServer;
import dao.SanPhamServer;
import dao.TaiKhoanServer;
import dao.ThongKeServer;
import dao.impl.ChiTietHoaDon_Dao;
import dao.impl.ChiTietPhieuDatPhong_Dao;
import dao.impl.ChiTietPhieuGoiMon_Dao;
import dao.impl.ChucVu_Dao;
import dao.impl.HoaDon_Dao;
import dao.impl.KhachHang_Dao;
import dao.impl.LoaiDichVu_Dao;
import dao.impl.LoaiPhong_Dao;
import dao.impl.LoaiSanPham_Dao;
import dao.impl.NhanVien_Dao;
import dao.impl.PhieuDatPhong_Dao;
import dao.impl.PhieuGoiMon_Dao;
import dao.impl.Phong_Dao;
import dao.impl.SanPham_Dao;
import dao.impl.TaiKhoan_Dao;
import dao.impl.ThongKe_Dao;

public class Server {
	private static final String URL = Types.URL;

	public static void main(String[] args) {
		try {
			
				LoaiPhongServer lp_dao = new LoaiPhong_Dao();
				PhongServer p_dao = new Phong_Dao();
				
				ChucVuSerer cv_dao = new ChucVu_Dao();
				NhanVienServer nv_dao = new NhanVien_Dao();
				TaiKhoanServer tk_dao = new TaiKhoan_Dao();
				
				SanPhamServer sp_dao = new SanPham_Dao();
				LoaiSanPhamServer lsp_dao = new LoaiSanPham_Dao();
				LoaiDichVuServer ldv_dao = new LoaiDichVu_Dao();
				
				KhachHangServer kh_dao = new KhachHang_Dao();
				HoaDonServer hd_dao = new HoaDon_Dao();
				ChiTietHoaDonServer cthd_dao = new ChiTietHoaDon_Dao();

				PhieuDatPhongServer pdp_dao = new PhieuDatPhong_Dao();
				ChiTietPhieuDatPhongServer ctpdp_dao = new ChiTietPhieuDatPhong_Dao();
				
				PhieuGoiMonServer pgm_dao = new PhieuGoiMon_Dao();
				ChiTietPhieuGoiMonServer ctpgm_dao = new ChiTietPhieuGoiMon_Dao();
				
				ThongKeServer tke_dao = new ThongKe_Dao();
				
				Context context = new InitialContext();
				
				LocateRegistry.createRegistry(7878);
				
				context.bind(URL + "LoaiPhongServer", lp_dao);
				context.bind(URL + "PhongServer", p_dao);
				// CHÍNH
				context.bind(URL + "ChucVuServer", cv_dao);
				context.bind(URL + "NhanVienServer", nv_dao);
				context.bind(URL + "TaiKhoanServer", tk_dao);
				
				context.bind(URL + "SanPhamServer", sp_dao);
				context.bind(URL + "LoaiSanPhamServer", lsp_dao);
				context.bind(URL + "LoaiDichVuServer", ldv_dao);
				
				context.bind(URL + "KhachHangServer", kh_dao);
				context.bind(URL + "HoaDonServer", hd_dao);
				context.bind(URL + "ChiTietHoaDonServer", cthd_dao);
				
				context.bind(URL + "PhieuDatPhongServer", pdp_dao);
				context.bind(URL + "ChiTietPhieuDatPhongServer", ctpdp_dao);
				
				context.bind(URL + "PhieuGoiMonServer", pgm_dao);
				context.bind(URL + "ChiTietPhieuGoiMonServer", ctpgm_dao);
				
				context.bind(URL+ThongKeServer.class.getSimpleName(), tke_dao);
				
				System.out.println("Server is running...");
			} catch (RemoteException | NamingException e) {
				e.printStackTrace();
			}
	}
}
