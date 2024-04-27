package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.LoaiSanPham;

public interface LoaiSanPhamServer extends Remote{

	public boolean add(LoaiSanPham loaiSanPham) throws RemoteException;
	public boolean update(LoaiSanPham loaiSanPham) throws RemoteException;
	public LoaiSanPham find(String maLSP) throws RemoteException;
	public LoaiSanPham findName(String name) throws RemoteException;
	public List<LoaiSanPham> getAll() throws RemoteException;
	
}
