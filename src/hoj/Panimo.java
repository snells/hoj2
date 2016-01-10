package hoj;

import java.rmi.server.UnicastRemoteObject;
public class Panimo extends UnicastRemoteObject implements PanimoInter {
	
	public Panimo() {}

	public get

	@Override
	public boolean loaderStart(Client c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean reserveSilo(Client c, int num) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean startSiloPump(Client c, int num) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean startProcessor(Client c, int num) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean startPump(Client c, int num) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean reserveTank(Client c, int num) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean startBottlePump(Client c, int num) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
