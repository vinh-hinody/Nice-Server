package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.NhanVien;
import entity.TaiKhoan;

public interface TaiKhoanServer extends Remote{
	
	public boolean add(TaiKhoan tk) throws RemoteException;
	public boolean update(TaiKhoan tk) throws RemoteException;
	public TaiKhoan find(String id) throws RemoteException;
	public List<TaiKhoan> getAll() throws RemoteException;
	public NhanVien checkLogin(String tk, String mk) throws RemoteException;
}
