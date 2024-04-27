package test;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import constant.Types;
import dao.ThongKeServer;
import entity.ThongKe;

public class Test_Tke {
	private static final String URL = Types.URL;
	
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		ThongKeServer tk_dao;
		tk_dao = (ThongKeServer) Naming.lookup(URL + ThongKeServer.class.getSimpleName());
        for (ThongKe tk : tk_dao.lay_TongThu_TongChi_LoiNhuan_TrongNam(2024, 1, 6)) {
        	System.out.println(tk);
//        	chart.addData(new ModelChart("Ngày " + tk.getThang(), new double[]{tk.getTongThu(), tk.getTongChi(), tk.getLoiNhuan()}));
		}
	}
}
