package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.ChiTietPhieuDatPhong;
import entity.PhieuDatPhong;
import entity.Phong;

public interface ChiTietPhieuDatPhongServer extends Remote{
	
	public boolean add(ChiTietPhieuDatPhong chiTietPhieuDP) throws RemoteException;
	public boolean update(ChiTietPhieuDatPhong chiTietPhieuDatPhong) throws RemoteException;
	public boolean update(ChiTietPhieuDatPhong chiTietPhieuDP, Phong phong_moi) throws RemoteException;
	public ChiTietPhieuDatPhong find(PhieuDatPhong datPhong, Phong phong) throws RemoteException;
	public List<ChiTietPhieuDatPhong> getAll() throws RemoteException;
	public void updateRoomNew(String maPhieuDP, String maP, String maP_new) throws RemoteException;
}
