package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.Phong;

public interface PhongServer extends Remote {
	
	public boolean add(Phong phong) throws RemoteException;
	public boolean update(Phong phong) throws RemoteException;
	public Phong find(String id) throws RemoteException;
	public List<Phong> getAll() throws RemoteException;
	public List<Phong> getRoomTypeAndCount(String staicRoom, String roomTypeAll, String roomCountPeopleAll) throws RemoteException;
	public Phong findName(String name) throws RemoteException;
	public void updateStatius(String maP, String tinhTrang) throws RemoteException;
	public void close() throws RemoteException;
}
