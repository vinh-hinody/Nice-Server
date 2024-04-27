package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.LoaiDichVuServer;
import entity.LoaiDichVu;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class LoaiDichVu_Dao extends UnicastRemoteObject implements LoaiDichVuServer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EntityManager em;

	public LoaiDichVu_Dao() throws RemoteException {
		em = Persistence.createEntityManagerFactory("update").createEntityManager();
	}

	@Override
	public boolean add(LoaiDichVu dichVu) throws RemoteException {
		EntityTransaction tr = em.getTransaction();

		try {
			tr.begin();
			em.persist(dichVu);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public LoaiDichVu find(String id) throws RemoteException {
		return em.find(LoaiDichVu.class, id);
	}

	@Override
	public List<LoaiDichVu> getAll() throws RemoteException {
		em = Persistence.createEntityManagerFactory("none").createEntityManager();
		return em.createQuery("select u from LoaiDichVu u", LoaiDichVu.class).getResultList();
	}

	@Override
	public boolean update(LoaiDichVu dichVu) throws RemoteException {
		EntityTransaction tr = em.getTransaction();

		try {
			tr.begin();
			em.merge(dichVu);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public LoaiDichVu findName(String name) throws RemoteException {
		var list = getAll();
		for (LoaiDichVu loaiDichVu : list) {
			if (loaiDichVu.getTen().equals(name)) {
				return loaiDichVu;
			}
		}
		return null;
	}
}
