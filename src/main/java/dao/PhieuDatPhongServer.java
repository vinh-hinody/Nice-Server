package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.PhieuDatPhong;

public interface PhieuDatPhongServer extends Remote{
	
	public boolean add(PhieuDatPhong phieuDatPhong) throws RemoteException;
	public boolean update(PhieuDatPhong phieuDatPhong) throws RemoteException;
	public PhieuDatPhong find(String maPDP) throws RemoteException;
	public List<PhieuDatPhong> getAll() throws RemoteException;
}
