package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import dao.ThongKeServer;
import entity.ThongKe;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class ThongKe_Dao extends UnicastRemoteObject implements ThongKeServer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EntityManager em;
	
	public ThongKe_Dao() throws RemoteException {
		em = Persistence.createEntityManagerFactory("update").createEntityManager();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<ThongKe> lay_TongThu_TongChi_LoiNhuan_TrongNam(int nam, int tuThang, int denThang) throws RemoteException {
			return em.createNativeQuery("select TIENTHU = SUM(DATEDIFF(MINUTE, ctpdp.tgVao, ctpdp.tgRa)/60.0*p.giaP) + SUM(sp.giaBan * ctpgm.soLuong)\r\n"
					+ "	, TIENCHI = SUM( ctpgm.soLuong * sp.giaBan)\r\n"
					+ "	, LOINHUAN = SUM(DATEDIFF(MINUTE, ctpdp.tgVao, ctpdp.tgRa)/60.0*p.giaP) + SUM(sp.giaBan * ctpgm.soLuong) - SUM( ctpgm.soLuong * sp.giaBan)\r\n"
					+ "	, THANG = MONTH(ctpdp.tgRa)\r\n"
					+ "	, NGAY = DAY(ctpdp.tgRa)\r\n"
					+ "	, NAM = YEAR(ctpdp.tgRa)\r\n"
					+ "from ChiTietHoaDon as cthd inner join ChiTietPhieuDatPhong as ctpdp \r\n"
					+ "on cthd.maPDP = ctpdp.maPDP inner join Phong as p \r\n"
					+ "on p.maP = ctpdp.maP inner join ChiTietPhieuGoiMon as ctpgm\r\n"
					+ "on ctpgm.maPGM = cthd.maPGM inner join SanPham as sp\r\n"
					+ "on sp.maSP = ctpgm.maSP\r\n"
					+ "where YEAR(ctpdp.tgRa) = :nam and  MONTH(ctpdp.tgRa) BETWEEN :tuThang and :denThang\r\n"
					+ "GROUP BY MONTH(ctpdp.tgRa), DAY(ctpdp.tgRa), YEAR(ctpdp.tgRa)", ThongKe.class)
					.setParameter("nam", nam)
					.setParameter("tuThang", tuThang)
					.setParameter("denThang", denThang)
					.getResultList();
	}

	 
}
