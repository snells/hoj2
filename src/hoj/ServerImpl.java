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
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean loaderStart(String n) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean siloReserve(String n, int num) throws RemoteException {
		return panimo.siloReserve(n,  num);
	}


	@Override
	public boolean siloPumpStart(String n, int num) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean processorReserve(String n, int num) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean processorStart(String n, int num) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean pumpStart(String n, int num) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean tankReserve(String n, int num) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean bottlePumpStart(String n, int num) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	@Override
	public boolean siloFree(String n, int num) throws RemoteException {
		return panimo.siloFree(n,  num);
	}
	@Override
	public PanimoData getData() throws RemoteException {
		return panimo.getData();
		
	}
	

}
