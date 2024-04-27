package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.ChucVu;

public interface ChucVuSerer extends Remote{

	public boolean add(ChucVu cv) throws RemoteException;
	public boolean update(ChucVu cv) throws RemoteException;
	public ChucVu find(String id) throws RemoteException;
	public List<ChucVu> getAll() throws RemoteException;
	
}
