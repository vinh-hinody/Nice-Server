package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.SanPhamServer;
import entity.SanPham;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class SanPham_Dao extends UnicastRemoteObject implements SanPhamServer {

	public SanPham_Dao() throws RemoteException {
		em = Persistence.createEntityManagerFactory("update").createEntityManager();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EntityManager em;

	@Override
	public boolean add(SanPham sp) throws RemoteException {
		EntityTransaction tr = em.getTransaction();

		try {
			tr.begin();
			em.persist(sp);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(SanPham sp) throws RemoteException {
		EntityTransaction tr = em.getTransaction();

		try {
			tr.begin();
			em.merge(sp);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public SanPham find(String id) throws RemoteException {
		return em.find(SanPham.class, id);
	}

	@Override
	public List<SanPham> getAll() throws RemoteException {
		em = Persistence.createEntityManagerFactory("none").createEntityManager();
		return em.createQuery("select u from SanPham u", SanPham.class).getResultList();
	}

	@Override
	public SanPham findName(String tenSP) throws RemoteException {
		var list = getAll();
		for (SanPham sanPham : list) {
			if(sanPham.getTenSP().equalsIgnoreCase(tenSP))
				return sanPham;
		}
		return null;
	}

	@Override
	public List<SanPham> getAllProductHaveTypeService(String typeService) throws RemoteException {
		return getAll()
				.stream()
				.filter(t -> t.getMaLSP().getTenLSP().equalsIgnoreCase(typeService))
				.toList();
	}

}
