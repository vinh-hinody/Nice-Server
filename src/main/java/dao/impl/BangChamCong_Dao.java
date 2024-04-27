package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.util.List;

import dao.BangChamCongServer;
import entity.BangChamCong;
import entity.CaTruc;
import entity.NhanVien;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class BangChamCong_Dao extends UnicastRemoteObject implements BangChamCongServer {

	private EntityManager em;

	public BangChamCong_Dao() throws RemoteException {
		em = Persistence.createEntityManagerFactory("update").createEntityManager();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public boolean add(BangChamCong bcc) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(bcc);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(BangChamCong bcc) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(bcc);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public BangChamCong find(LocalDate ngay, CaTruc caTruc, NhanVien nhanVien) throws RemoteException {
		for (var bcc : getAll()) {
			var ob = bcc.getBangChamCong_ID();
			if( ob.getMaCT().equals(caTruc) && ob.getNgay().equals(ngay) && ob.getMaNV().equals(nhanVien))
				return bcc;
		}
		return null;
	}

	@Override
	public List<BangChamCong> getAll() throws RemoteException {
		em = Persistence.createEntityManagerFactory("none").createEntityManager();
		return em.createQuery("select u from BangChamCong u", BangChamCong.class).getResultList();
	}

}
