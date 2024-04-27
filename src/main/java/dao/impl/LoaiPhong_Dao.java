package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.LoaiPhongServer;
import entity.LoaiPhong;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class LoaiPhong_Dao extends UnicastRemoteObject implements LoaiPhongServer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EntityManager em;

	public LoaiPhong_Dao() throws RemoteException {
		em = Persistence.createEntityManagerFactory("update").createEntityManager();
	}

	@Override
	public boolean add(LoaiPhong lp) throws RemoteException {
		if (find(lp.getMaLP()) != null)
			return false;
		else {
			EntityTransaction tr = em.getTransaction();

			try {
				tr.begin();
				em.persist(lp);
				tr.commit();
				return false;
			} catch (Exception e) {
				tr.rollback();
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean update(LoaiPhong lp) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(lp);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public LoaiPhong find(String id) throws RemoteException {
		return em.find(LoaiPhong.class, id);
	}

	@Override
	public List<LoaiPhong> getAll() throws RemoteException {
		em = Persistence.createEntityManagerFactory("none").createEntityManager();
		return em.createQuery("Select u from LoaiPhong u", LoaiPhong.class).getResultList();
	}

	@Override
	public LoaiPhong findName(String name) throws RemoteException {
		var list = getAll();
		for (LoaiPhong loaiPhong : list) {
			if (loaiPhong.getTenLP().equals(name))
				return loaiPhong;
		}
		return null;
	}

}
