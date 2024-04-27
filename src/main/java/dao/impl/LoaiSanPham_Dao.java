package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.LoaiSanPhamServer;
import entity.LoaiSanPham;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class LoaiSanPham_Dao extends UnicastRemoteObject implements LoaiSanPhamServer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoaiSanPham_Dao() throws RemoteException {
		em = Persistence.createEntityManagerFactory("update").createEntityManager();
	}

	private EntityManager em;

	@Override
	public boolean add(LoaiSanPham loaiSanPham) throws RemoteException {
		EntityTransaction tr = em.getTransaction();

		try {
			tr.begin();
			em.persist(loaiSanPham);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(LoaiSanPham loaiSanPham) throws RemoteException {
		EntityTransaction tr = em.getTransaction();

		try {
			tr.begin();
			em.merge(loaiSanPham);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public LoaiSanPham find(String maLSP) throws RemoteException {
		return em.find(LoaiSanPham.class, maLSP);
	}
	
	@Override
	public LoaiSanPham findName(String name) throws RemoteException {
		var list = getAll();
		for (LoaiSanPham loaiSanPham : list) {
			if(loaiSanPham.getTenLSP().equalsIgnoreCase(name))
				return loaiSanPham;
		}
		return null;
	}

	@Override
	public List<LoaiSanPham> getAll() throws RemoteException {
		em = Persistence.createEntityManagerFactory("none").createEntityManager();
		return em.createQuery("select u from LoaiSanPham u", LoaiSanPham.class).getResultList();
	}

}
