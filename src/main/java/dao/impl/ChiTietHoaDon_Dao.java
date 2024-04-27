package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.ChiTietHoaDonServer;
import entity.ChiTietHoaDon;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class ChiTietHoaDon_Dao extends UnicastRemoteObject implements ChiTietHoaDonServer {

	private EntityManager em;

	public ChiTietHoaDon_Dao() throws RemoteException {
		em = Persistence.createEntityManagerFactory("update").createEntityManager();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public boolean add(ChiTietHoaDon chiTietHoaDon) throws RemoteException {
		EntityTransaction tr = em.getTransaction();

		try {
			tr.begin();
			em.persist(chiTietHoaDon);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(ChiTietHoaDon chiTietHoaDon) throws RemoteException {
		em = Persistence.createEntityManagerFactory("none").createEntityManager();
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(chiTietHoaDon);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ChiTietHoaDon find(String maHD) throws RemoteException {
		return em.find(ChiTietHoaDon.class, maHD);
	}

	@Override
	public List<ChiTietHoaDon> getAll() throws RemoteException {
		em = Persistence.createEntityManagerFactory("none").createEntityManager();
		return em.createQuery("select u from ChiTietHoaDon u", ChiTietHoaDon.class).getResultList();
	}

	@Override
	public ChiTietHoaDon timHoaDonCuaPhong(String maP, String tinhTrang) throws RemoteException {
		try {
			return em.createNamedQuery("ChiTietHoaDon.timHoaDonCuaPhong", ChiTietHoaDon.class).setParameter("maP", maP)
					.setParameter("tinhTrang", tinhTrang).getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

}
