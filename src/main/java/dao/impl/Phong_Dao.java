package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Comparator;
import java.util.List;

import dao.PhongServer;
import entity.Phong;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Phong_Dao extends UnicastRemoteObject implements PhongServer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EntityManager em;

	public Phong_Dao() throws RemoteException {
		em = Persistence.createEntityManagerFactory("update").createEntityManager();
	}

	@Override
	public boolean add(Phong phong) throws RemoteException {
		EntityTransaction tr = em.getTransaction();

		try {
			tr.begin();
			em.persist(phong);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Phong phong) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(phong);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Phong find(String id) throws RemoteException {
		return em.find(Phong.class, id);
	}

	@Override
	public List<Phong> getAll() throws RemoteException {
		em = Persistence.createEntityManagerFactory("none").createEntityManager();
		return em.createQuery("select u from Phong u", Phong.class).getResultList()
				.stream().sorted(Comparator.comparingInt(obj -> Integer.parseInt(obj.getMaP()))).toList();
	}

	@Override
	public List<Phong> getRoomTypeAndCount(String staicRoom, String roomTypeAll, String roomCountPeopleAll)
			throws RemoteException {
		return null;
	}

	@Override
	public Phong findName(String name) throws RemoteException {
		return getAll().stream().filter(t -> t.getTenP().equals(name)).findFirst().get();
	}

	@Override
	public void updateStatius(String maP, String tinhTrang) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.createNativeQuery("update Phong set tinhTrang = :tinhTrang where maP = :maP", Phong.class)
			.setParameter("tinhTrang", tinhTrang)
			.setParameter("maP", maP)
			.executeUpdate();
			tr.commit();
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		
	}

	@Override
	public void close() throws RemoteException {
		em.close();
		
	}


}
