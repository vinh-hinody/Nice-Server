package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.ChiTietHoaDon;
import entity.SanPham;

public interface ChiTietHoaDonServer extends Remote{

	public boolean add(ChiTietHoaDon chiTietHoaDon) throws RemoteException;
	public boolean update(ChiTietHoaDon chiTietHoaDon) throws RemoteException;
	public ChiTietHoaDon find(String maHD) throws RemoteException;
	public List<ChiTietHoaDon> getAll() throws RemoteException;
	public ChiTietHoaDon timHoaDonCuaPhong(String maP, String trinhTrang) throws RemoteException;
}
