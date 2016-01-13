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
				Thread.sleep(500);
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
	
}
