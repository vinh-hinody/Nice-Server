package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.PhieuGoiMon;
import entity.SanPham;

public interface PhieuGoiMonServer extends Remote{
	
	public boolean add(PhieuGoiMon phieuGoiMon) throws RemoteException;
	public boolean update(PhieuGoiMon phieuGoiMon) throws RemoteException;
	public PhieuGoiMon find(String maPGM) throws RemoteException;
	public List<PhieuGoiMon> getAll() throws RemoteException;
	public List<String> findAllProductOfRoom(String maP) throws RemoteException;
	public String findPGM_Id(String maP) throws RemoteException;
	public List<SanPham> getProductsOfOrderDidPayment(String maP) throws RemoteException;
	public List<SanPham> getOrderFoodPresent(String maP) throws RemoteException;
}
