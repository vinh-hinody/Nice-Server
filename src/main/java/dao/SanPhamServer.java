package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.SanPham;

public interface SanPhamServer extends Remote{

	public boolean add(SanPham sp) throws RemoteException;
	public boolean update(SanPham sp) throws RemoteException;
	public SanPham find(String maSP) throws RemoteException;
	public List<SanPham> getAll() throws RemoteException;
	public List<SanPham> getAllProductHaveTypeService(String typeService) throws RemoteException;
	public SanPham findName(String maSP) throws RemoteException;
	
}
