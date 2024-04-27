package test;

import java.rmi.RemoteException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import dao.ChiTietHoaDonServer;
import dao.ChiTietPhieuDatPhongServer;
import dao.impl.ChiTietHoaDon_Dao;
import dao.impl.ChiTietPhieuDatPhong_Dao;
import entity.ChiTietHoaDon;
import entity.ChiTietPhieuDatPhong;


@TestInstance(Lifecycle.PER_CLASS)
class StudentDAOTest {
	
	@Test
	public void testHoaDoon() {
		try {
			ChiTietHoaDonServer dao = new ChiTietHoaDon_Dao();
			var list = dao.getAll();
			for (ChiTietHoaDon cthd : list) {
				System.out.println(cthd.getMaPhieuDP());
				System.out.println(cthd.getMaHD());
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testChiToetPDP() {
		try {
			ChiTietPhieuDatPhongServer dao = new ChiTietPhieuDatPhong_Dao();
			var list = dao.getAll();
			for (ChiTietPhieuDatPhong cthd : list) {
				System.out.println(cthd);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

}
