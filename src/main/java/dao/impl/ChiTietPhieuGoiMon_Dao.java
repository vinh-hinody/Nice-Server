package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.ChiTietPhieuGoiMonServer;
import entity.ChiTietPhieuGoiMon;
import entity.ChiTietPhieuGM_ID;
import entity.PhieuGoiMon;
import entity.SanPham;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class ChiTietPhieuGoiMon_Dao extends UnicastRemoteObject implements ChiTietPhieuGoiMonServer {

	private EntityManager em;

	public ChiTietPhieuGoiMon_Dao() throws RemoteException {
		em = Persistence.createEntityManagerFactory("update").createEntityManager();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public boolean add(ChiTietPhieuGoiMon chiTietPhieuGM) throws RemoteException {
		EntityTransaction tr = em.getTransaction();

		try {
			tr.begin();
			em.persist(chiTietPhieuGM);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean update(ChiTietPhieuGoiMon chiTietPhieuGM) throws RemoteException {
		EntityTransaction tr = em.getTransaction();

		try {
			tr.begin();
			em.merge(chiTietPhieuGM);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public List<ChiTietPhieuGoiMon> getAll() throws RemoteException {
		return em.createQuery("select u from ChiTietPhieuGoiMon u", ChiTietPhieuGoiMon.class).getResultList();
	}

	@Override
	public ChiTietPhieuGoiMon find(PhieuGoiMon goiMon, SanPham sanPham) throws RemoteException {
		return em.find(ChiTietPhieuGoiMon.class, new ChiTietPhieuGM_ID(goiMon, sanPham));
	}

	@Override
	public List<SanPham> getProducts(String maPGM) throws RemoteException {

		return getAll().stream().filter(t -> t.getMaPGM().getMaPGM().equalsIgnoreCase(maPGM))
				.map(ChiTietPhieuGoiMon::getMaSP).toList();
	}

	@Override
	public ChiTietPhieuGoiMon find(PhieuGoiMon goiMon, String maSP) throws RemoteException {
		return getAll().stream().filter(t -> (t.getMaPGM().getMaPGM().equals(goiMon.getMaPGM()))
				&& (t.getMaSP().getMaSP().equalsIgnoreCase(maSP))).findFirst().get();
	}

	@Override
	public boolean updateWhenPayment(PhieuGoiMon pgm) throws RemoteException {

		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.createNativeQuery(
					"update ChiTietPhieuGoiMon set tinhTrang = :tinhTrang where maPGM = :maPGM and tinhTrang = :tinhTrang2",
					ChiTietPhieuGoiMon.class).setParameter("tinhTrang", pgm.getTinhTrang())
					.setParameter("maPGM", pgm.getMaPGM()).setParameter("tinhTrang2", "CHƯA THANH TOÁN")
					.executeUpdate();
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public boolean remove(String maPGM, String maSP) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.createNativeQuery("DELETE FROM ChiTietPhieuGoiMon WHERE maPGM = :maPGM and maSP = :maSP",
					ChiTietPhieuGoiMon.class).setParameter("maPGM", maPGM).setParameter("maSP", maSP).executeUpdate();
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}

}
