package hoj;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.rmi.Naming;


public class Client extends UnicastRemoteObject implements ClientInter, Runnable  {

	public Client() throws RemoteException {
		new Thread (this).start();
		
	}
	
	private String name;
	private Server server;
	
	
	public void run() {
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public void updateSilo(ContainerData d, int num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateLoader() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateSiloPump(int num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProcessor(ContainerData d, int num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTank(ContainerData d, int num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void UpdateBottlePump(int num) {
		// TODO Auto-generated method stub
		
	}

}
