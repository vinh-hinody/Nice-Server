package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.NhanVienServer;
import entity.NhanVien;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class NhanVien_Dao extends UnicastRemoteObject implements NhanVienServer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NhanVien_Dao() throws RemoteException {
		em = Persistence.createEntityManagerFactory("update").createEntityManager();
	}

	private EntityManager em;

	@Override
	public boolean add(NhanVien nhanVien) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(nhanVien);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(NhanVien nhanVien) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(nhanVien);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public NhanVien find(int id) throws RemoteException {
		return em.find(NhanVien.class, id);
	}

	@Override
	public List<NhanVien> getAll() throws RemoteException {
		em = Persistence.createEntityManagerFactory("none").createEntityManager();
		return em.createQuery("select u from NhanVien u", NhanVien.class).getResultList();
	}

}
