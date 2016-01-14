package hoj;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.rmi.Naming;


public class Client extends UnicastRemoteObject implements ClientInter, Runnable  {

	public Client(MainWindow w, Server s, String n) throws RemoteException {
		name = n;
		server = s;
		window = w;
		
		new Thread (this).start();
		
	}
	
	private String name;
	private Server server;
	private MainWindow window;
	private boolean end = false;
	
	public void run() {
		while(!end) {
			try {
				PanimoData d = server.getData();
				window.update(d);
			} catch(RemoteException e) {
				e.printStackTrace();
			}
			try {
				Thread.sleep(250);
			} catch(Exception e) {}
		}
	}
	
	@Override
	public String getName() throws RemoteException {
		return name;
	}
	
	public void siloFree(int n) {
		try {
			server.siloFree(getName(), n);	
		} catch (RemoteException e) {}
	}
	public void siloReserve(int num) {
		try {
			server.siloReserve(getName(), num);	
		} catch (RemoteException e) {}
	}
	
	public void processorFree(int n) {
		try {
			server.processorFree(getName(), n);
		} catch (RemoteException e) {}
	}
	
	public void processorReserve(int n) {
		try {
			server.processorReserve(getName(), n);
		} catch (RemoteException e) {}
	}
	
	public void tankFree(int n) {
		try {
			server.tankFree(getName(), n);
		} catch (RemoteException e) {}
	}
	
	public void tankReserve(int n) {
		try {
			server.tankReserve(getName(), n);
		} catch (RemoteException e) {e.printStackTrace();}
	}
	
	public void loaderStart() {
		System.out.println("CLIENT loader start");
		try {
			server.loaderStart(name);
		} catch (RemoteException e) {e.printStackTrace();}
	}
	public void siloPumpStart(int num, int count) {
		System.out.println("CLIENT silo pump start");
		try {
			server.siloPumpStart(name,  num, count);
		} catch (RemoteException e) {e.printStackTrace();}
	}
	public void pumpStart(int n) {
		System.out.println("CLIENT pump start");
		try {
			server.pumpStart(name,  n);
		} catch (RemoteException e) {e.printStackTrace();}
	}
	public void bottlePumpStart(int n) {
		System.out.println("CLIENT bottle pump start");
		try {
			server.bottlePumpStart(name,  n);
		} catch (RemoteException e) {e.printStackTrace();}
	}
	public void processorStart(int n) {
		System.out.println("CLIENT processor start");
		try {
			server.processorStart(name, n);
		} catch (RemoteException e) {e.printStackTrace();}
	}
}
