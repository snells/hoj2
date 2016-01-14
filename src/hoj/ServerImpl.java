package hoj;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.LocateRegistry;


public class ServerImpl extends UnicastRemoteObject implements Server  {
	
	Panimo panimo;
	public ServerImpl() throws RemoteException {
		panimo = new Panimo();

	}
	
	
	public static void main(String args[]) throws Exception {
		LocateRegistry.createRegistry(9001);

		Naming.rebind("//localhost:9001/panimo",  new ServerImpl());
	}
	
    

	@Override
	public boolean login(String n) throws RemoteException {
		return panimo.login(n);
	}


	@Override
	public boolean loaderStart(String n) throws RemoteException {
		System.out.println("SERVER loader start");
		return panimo.loaderStart(n);
	}


	@Override
	public boolean siloReserve(String n, int num) throws RemoteException {
		return panimo.siloReserve(n,  num);
	}


	@Override
	public boolean siloPumpStart(String n, int num, int count) throws RemoteException {
		System.out.println("SERVER silo pump start with count " + count);
		return panimo.siloPumpStart(n, num, count);
			}


	@Override
	public boolean processorReserve(String n, int num) throws RemoteException {
		return panimo.processorReserve(n,  num);
	}


	@Override
	public boolean processorStart(String n, int num) throws RemoteException {
		System.out.println("SERVER processor start");
		return panimo.processorStart(n,  num);
	}


	@Override
	public boolean pumpStart(String n, int num) throws RemoteException {
		System.out.println("SERVER pump start");
		return panimo.pumpStart(n, num);
	}


	@Override
	public boolean tankReserve(String n, int num) throws RemoteException {
		return panimo.tankReserve(n,  num);
	}


	@Override
	public boolean bottlePumpStart(String n, int num) throws RemoteException {
		System.out.println("SERVER bottle pump start");
		return panimo.bottlePumpStart(n, num);
	}
	
	
	@Override
	public boolean siloFree(String n, int num) throws RemoteException {
		return panimo.siloFree(n,  num);
	}
	
	@Override
	public boolean tankFree(String n, int num) throws RemoteException {
		return panimo.tankFree(n, num);
	}
	
	@Override
	public boolean processorFree(String n, int num) throws RemoteException {
		return panimo.processorFree(n, num);
	}
	
	@Override
	public PanimoData getData() throws RemoteException {
		return panimo.getData();
		
	}
	

}
