package hoj;

public abstract class TransferPump<T extends Container> extends Thread {
	protected int speed; // stuff / second 
	protected T contIn;
	protected T contOut;
	protected volatile boolean inUse;
	protected boolean startFlag;
	protected String user;
	
	
	private boolean transfer(int count) {
		long c = Math.min(count, contIn.getStuff());
		c = Math.min(c, contOut.roomLeft());
		if(c == 0)
			return false;
		else {
			contIn.transfer(c);
			contOut.transfer(c);
			return true;
		}
	}
	public boolean isFree() {
		return !inUse;
	}
	
	public synchronized boolean prepare(String name, T in, T out) {
		if(inUse)
			return false;
		if(in == null || out == null)
			return false;
		if(!in.validateUser(name) || !out.validateUser(name))
			return false;
		if(!in.connect(true))
			return false;
		if(!out.connect(false))
			return false;
		inUse = true;
		in.startTransfer(true);
		out.startTransfer(false);
		user = name;
		startFlag = true;
		contIn = in;
		contOut = out;
		return true;
	}
	
	private void work() {
		while(transfer(speed)) {
			try {
				Thread.sleep(1000);
			} catch(Exception t) {}
		}
		inUse = false;
		contIn.stopTransfer();
		if(contIn.getStuff() == 0)
			contIn.free(user);
		contOut.stopTransfer();
	}
	
	
	public abstract void run();
}
