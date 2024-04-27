package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.NhanVien;

public interface NhanVienServer extends Remote{
	
	public boolean add(NhanVien nhanVien) throws RemoteException;
	public boolean update(NhanVien nhanVien) throws RemoteException;
	public NhanVien find(int id) throws RemoteException;
	public List<NhanVien> getAll() throws RemoteException;
}
