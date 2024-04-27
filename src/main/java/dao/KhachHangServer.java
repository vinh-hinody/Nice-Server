package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.KhachHang;

public interface KhachHangServer extends Remote{
	
	public boolean add(KhachHang khachHang) throws RemoteException;
	public boolean update(KhachHang khachHang) throws RemoteException;
	public boolean find(String sdt) throws RemoteException;
	public List<KhachHang> getAll() throws RemoteException;
	public KhachHang getSelectedKhachHang(int index) throws RemoteException; 
	public KhachHang findB(String sdt) throws RemoteException;
	public KhachHang findA(String sdt) throws RemoteException;
}