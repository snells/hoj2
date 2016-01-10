package hoj;

import java.rmi.server.UnicastRemoteObject;

public class Client extends UnicastRemoteObject implements ClientInter, Runnable  {

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
