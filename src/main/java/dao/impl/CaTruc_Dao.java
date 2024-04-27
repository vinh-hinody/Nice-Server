package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.CaTrucServer;
import entity.CaTruc;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class CaTruc_Dao extends UnicastRemoteObject implements CaTrucServer {

	/**
	 * 
	 */
	private static final long serialVersionUID = -229064689287703555L;
	private EntityManager em;

	public CaTruc_Dao() throws RemoteException {
		em = Persistence.createEntityManagerFactory("update").createEntityManager();
	}

	@Override
	public boolean add(CaTruc caTruc) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(caTruc);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<CaTruc> getAllDB() throws RemoteException {
		em = Persistence.createEntityManagerFactory("none").createEntityManager();
		return em.createQuery("select s from CaTruc s", CaTruc.class).getResultList();
	}

}
