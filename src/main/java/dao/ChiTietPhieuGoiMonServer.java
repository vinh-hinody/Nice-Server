package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.ChiTietPhieuGoiMon;
import entity.PhieuGoiMon;
import entity.SanPham;

public interface ChiTietPhieuGoiMonServer extends Remote{
	
	public boolean add(ChiTietPhieuGoiMon chiTietPhieuGM) throws RemoteException;
	public boolean update(ChiTietPhieuGoiMon chiTietPhieuGM) throws RemoteException;
	public ChiTietPhieuGoiMon find(PhieuGoiMon goiMon, SanPham sanPham) throws RemoteException;
	public List<ChiTietPhieuGoiMon> getAll() throws RemoteException;
	public List<SanPham> getProducts(String maPGM) throws RemoteException;
	public ChiTietPhieuGoiMon find(PhieuGoiMon goiMon, String maSP) throws RemoteException;
	public boolean updateWhenPayment(PhieuGoiMon pgm) throws RemoteException;
	public boolean remove(String maPGM, String maSP) throws RemoteException;
}
