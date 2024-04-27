package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.List;

import entity.BangChamCong;
import entity.CaTruc;
import entity.NhanVien;

public interface BangChamCongServer extends Remote{

	public boolean add(BangChamCong nhanVien) throws RemoteException;
	public boolean update(BangChamCong nhanVien) throws RemoteException;
	public BangChamCong find(LocalDate ngay, CaTruc caTruc, NhanVien nhanVien) throws RemoteException;
	public List<BangChamCong> getAll() throws RemoteException;
	
}
