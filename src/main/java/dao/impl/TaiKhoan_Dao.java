package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.TaiKhoanServer;
import entity.NhanVien;
import entity.TaiKhoan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class TaiKhoan_Dao extends UnicastRemoteObject implements TaiKhoanServer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EntityManager em;

	public TaiKhoan_Dao() throws RemoteException {
		em = Persistence.createEntityManagerFactory("update").createEntityManager();
	}

	@Override
	public boolean add(TaiKhoan tk) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(tk);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(TaiKhoan tk) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(tk);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public TaiKhoan find(String id) throws RemoteException {
		return em.find(TaiKhoan.class, id);
	}

	@Override
	public List<TaiKhoan> getAll() throws RemoteException {
		em = Persistence.createEntityManagerFactory("none").createEntityManager();
		return em.createQuery("select u from TaiKhoan u", TaiKhoan.class).getResultList();
	}

	@Override
	public NhanVien checkLogin(String tk, String mk) throws RemoteException {
		if (tk.length() == 0 || mk.length() == 0)
			return null;
		TaiKhoan taiKhoan = em.find(TaiKhoan.class, tk);
		if (taiKhoan.getMatKhau().equals(mk))
			return taiKhoan.getMaNV();
		return null;
	}

}
