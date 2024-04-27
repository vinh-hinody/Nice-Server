package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.HoaDon;

public interface HoaDonServer extends Remote{
	
	public boolean add(HoaDon dichVu) throws RemoteException;
	public boolean update(HoaDon dichVu) throws RemoteException;
	public HoaDon find(String id) throws RemoteException;
	public List<HoaDon> getAll() throws RemoteException;
}
