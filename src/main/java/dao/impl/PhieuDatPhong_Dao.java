package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.PhieuDatPhongServer;
import entity.PhieuDatPhong;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class PhieuDatPhong_Dao extends UnicastRemoteObject implements PhieuDatPhongServer{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EntityManager em;
	
	public PhieuDatPhong_Dao() throws RemoteException {
			em = Persistence.createEntityManagerFactory("update").createEntityManager();
	}

	@Override
	public boolean add(PhieuDatPhong phieuDatPhong) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(phieuDatPhong);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(PhieuDatPhong phieuDatPhong) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		
		try {
			tr.begin();
			em.merge(phieuDatPhong);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public PhieuDatPhong find(String maPDP) throws RemoteException {
		return em.find(PhieuDatPhong.class, maPDP);
	}

	@Override
	public List<PhieuDatPhong> getAll() throws RemoteException {
		em = Persistence.createEntityManagerFactory("none").createEntityManager();
		return em.createQuery("select u from PhieuDatPhong u", PhieuDatPhong.class).getResultList();
	}
	
}
