package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.ChiTietPhieuDatPhongServer;
import entity.ChiTietPhieuDP_ID;
import entity.ChiTietPhieuDatPhong;
import entity.PhieuDatPhong;
import entity.Phong;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class ChiTietPhieuDatPhong_Dao extends UnicastRemoteObject implements ChiTietPhieuDatPhongServer {

	private EntityManager em;

	public ChiTietPhieuDatPhong_Dao() throws RemoteException {
			em = Persistence.createEntityManagerFactory("update").createEntityManager();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public boolean add(ChiTietPhieuDatPhong chiTietPhieuDP) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		
		try {
			tr.begin();
			em.persist(chiTietPhieuDP);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(ChiTietPhieuDatPhong chiTietPhieuDP, Phong phong_moi) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.createNativeQuery("update ChiTietPhieuDatPhong set maP = :maP, tinhTrang = :tinhTrang where maPDP = :maPDP", ChiTietPhieuDatPhong.class)
			.setParameter("maP", phong_moi.getMaP())
			.setParameter("tinhTrang", chiTietPhieuDP.getTinhTrang())
			.setParameter("maPDP", chiTietPhieuDP.getMaPDP().getMaPhieuDP())
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
	public ChiTietPhieuDatPhong find(PhieuDatPhong datPhong, Phong phong) throws RemoteException {
		em = Persistence.createEntityManagerFactory("update").createEntityManager();
		return em.find(ChiTietPhieuDatPhong.class, new ChiTietPhieuDP_ID(datPhong, phong));
	}

	@Override
	public List<ChiTietPhieuDatPhong> getAll() throws RemoteException {
		em = Persistence.createEntityManagerFactory("update").createEntityManager();
		return em.createQuery("select u from ChiTietPhieuDatPhong u", ChiTietPhieuDatPhong.class).getResultList();
	}

	@Override
	public void updateRoomNew(String maPhieuDP, String maP, String maP_new) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		
		try {
			tr.begin();
			em.createNativeQuery("update ChiTietPhieuDatPhong set maP = :maP where maPDP = :maPDP", ChiTietPhieuDatPhong.class)
			.setParameter("maP", maP)
			.setParameter("maPDP", maPhieuDP)
			.executeUpdate();
			tr.commit();
			
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		
		
	}

	@Override
	public boolean update(ChiTietPhieuDatPhong chiTietPhieuDatPhong) throws RemoteException {
		
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(chiTietPhieuDatPhong);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}

}
