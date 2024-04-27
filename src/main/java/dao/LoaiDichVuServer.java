package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.LoaiDichVu;

public interface LoaiDichVuServer extends Remote{

	public boolean add(LoaiDichVu dichVu) throws RemoteException;
	public boolean update(LoaiDichVu dichVu) throws RemoteException;
	public LoaiDichVu find(String id) throws RemoteException;
	public List<LoaiDichVu> getAll() throws RemoteException;
	public LoaiDichVu findName(String name) throws RemoteException;
	
}
