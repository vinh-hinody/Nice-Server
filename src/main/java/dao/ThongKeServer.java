package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.ThongKe;

public interface ThongKeServer extends Remote{
	public List<ThongKe> lay_TongThu_TongChi_LoiNhuan_TrongNam(int nam, int tuThang, int denThang) throws RemoteException;
}
