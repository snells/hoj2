package hoj;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements ServerInter {
	
	Panimo panimo;
	public Server() throws RemoteException {
		panimo = new Panimo();

	}
	
	
	public static void main(String args[]) throws Exception {
		Naming.rebind("Panimo",  new Server());
	}
	
	
	@Override
	public boolean login(Client c) throws RemoteException {
		return panimo.login(c.getName());
		
	}
	@Override
	public boolean loaderStart(Client c) throws RemoteException {
		return panimo.loaderStart(c.getName());

	}
	@Override
	public boolean siloReserve(Client c, int num) throws RemoteException {
		return panimo.siloReserve(c.getName(), num - 1);
	}
	@Override
	public boolean siloPumpStart(Client c, int num) throws RemoteException {
		return panimo.siloPumpStart(c.getName(), num);
	}
	@Override
	public boolean processorReserve(Client c, int num) throws RemoteException {
		return panimo.processorReserve(c.getName(), num);
	}
	@Override
	public boolean processorStart(Client c, int num) throws RemoteException {
		return panimo.processorStart(c.getName(), num);
	}
	@Override
	public boolean pumpStart(Client c, int num) throws RemoteException {
		return panimo.pumpStart(c.getName(), num);
	}
	@Override
	public boolean tankReserve(Client c, int num) throws RemoteException {
		return panimo.tankReserve(c.getName(), num);
	}
	@Override
	public boolean bottlePumpStart(Client c, int num) throws RemoteException {
		return panimo.bottlePumpStart(c.getName(), num);
	}
    
	public PanimoData getData() {
		return panimo.getData();
	}
	
	
}
