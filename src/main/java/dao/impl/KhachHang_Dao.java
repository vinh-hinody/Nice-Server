package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collections;
import java.util.List;

import dao.KhachHangServer;
import entity.KhachHang;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class KhachHang_Dao extends UnicastRemoteObject implements KhachHangServer {

	private EntityManager em;

	public KhachHang_Dao() throws RemoteException {
		em = Persistence.createEntityManagerFactory("update").createEntityManager();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public boolean add(KhachHang khachHang) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(khachHang);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(KhachHang khachHang) throws RemoteException {
		em = Persistence.createEntityManagerFactory("update").createEntityManager();
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(khachHang);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean find(String sdt) throws RemoteException {
		try {
			TypedQuery<Long> query = em.createQuery("select count(u) from KhachHang u where u.sdt = :sdt", Long.class);
			query.setParameter("sdt", sdt);
			long count = query.getSingleResult();
			if (count > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public KhachHang findA(String sdt) throws RemoteException {
		return em.find(KhachHang.class, sdt);
	}

	@Override
	public List<KhachHang> getAll() throws RemoteException {
		try {
			em = Persistence.createEntityManagerFactory("update").createEntityManager();
			TypedQuery<KhachHang> query = em.createQuery("select u from KhachHang u", KhachHang.class);
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	@Override
	public KhachHang getSelectedKhachHang(int index) throws RemoteException {
		if (index < 0 || index > getAll().size()) {
			return null;
		}
		String sdt = getAll().get(index).getSdt();
		try {
			em = Persistence.createEntityManagerFactory("update").createEntityManager();
			TypedQuery<KhachHang> query = em.createQuery("Select u from KhachHang u where u.sdt = :sdt",
					KhachHang.class);
			query.setParameter("sdt", sdt);
			return query.getSingleResult();
		} catch (NoResultException e) {
			System.out.println("Không tìm thấy khách hàng với số điện thoại" + sdt);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public KhachHang findB(String sdt) throws RemoteException {
		return em.find(KhachHang.class, sdt);
	}
}
