package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.LoaiPhong;
import jakarta.persistence.EntityManager;

public interface LoaiPhongServer extends Remote {

	public boolean add(LoaiPhong lp) throws RemoteException;
	public boolean update(LoaiPhong lp) throws RemoteException;
	public LoaiPhong find(String id) throws RemoteException;
	public List<LoaiPhong> getAll() throws RemoteException;
	public LoaiPhong findName(String roomTypeVip) throws RemoteException;
}
