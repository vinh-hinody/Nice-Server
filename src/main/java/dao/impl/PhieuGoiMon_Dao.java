package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import dao.PhieuGoiMonServer;
import entity.PhieuGoiMon;
import entity.SanPham;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class PhieuGoiMon_Dao extends UnicastRemoteObject implements PhieuGoiMonServer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EntityManager em;

	public PhieuGoiMon_Dao() throws RemoteException {
			em = Persistence.createEntityManagerFactory("update").createEntityManager();
	}

	@Override
	public boolean add(PhieuGoiMon phieuGoiMon) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		
		try {
			tr.begin();
			em.persist(phieuGoiMon);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(PhieuGoiMon phieuGoiMon) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(phieuGoiMon);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public PhieuGoiMon find(String maPGM) throws RemoteException {
		return em.find(PhieuGoiMon.class, maPGM);
	}

	@Override
	public List<PhieuGoiMon> getAll() throws RemoteException {
		em = Persistence.createEntityManagerFactory("none").createEntityManager();
		return em.createQuery("select u from PhieuGoiMon u", PhieuGoiMon.class).getResultList();
	}

	public List<String> findAllProductOfRoom(String maP) throws RemoteException {
		return new ArrayList<String>();
	}

	@Override
	public String findPGM_Id(String maP) throws RemoteException {
		List<PhieuGoiMon> list = getAll();
		for (PhieuGoiMon phieuGoiMon : list) {
			if(phieuGoiMon.getMaP().getMaP().equalsIgnoreCase(maP))
				return phieuGoiMon.getMaPGM();
		}
		return null;
	}

	@Override
	public List<SanPham> getProductsOfOrderDidPayment(String maP) throws RemoteException {
		return new ArrayList<SanPham>();
	}

	@Override
	public List<SanPham> getOrderFoodPresent(String maP) throws RemoteException {
		
		return null;
	}

}
