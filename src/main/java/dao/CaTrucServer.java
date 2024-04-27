package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.CaTruc;

public interface CaTrucServer extends Remote{
	
	public boolean add(CaTruc caTruc) throws RemoteException;
	public List<CaTruc> getAllDB() throws RemoteException;

}
