package hoj;


// base class that all pumps inherit
public class TransferPump<T extends Container> extends Thread {
	protected int speed; // stuff / second 
	protected T contIn;  
	protected T contOut;
	protected volatile boolean inUse;
	protected volatile boolean startFlag = false; // set true to start transfer
	protected String user;
	protected boolean end = false; // set true to end thread
	protected boolean usingFiller;
	protected boolean usingDrain;
	
	
	// override to add extra tests to transfer 
	protected boolean extraTest() {
		return false;
	}
	

	private boolean transfer(int count) {
		if(extraTest())
			return false;
		long sin = contIn.getStuff();
		long rl = contOut.roomLeft();
		long c = Math.min(count, sin);
		c = Math.min(c, rl);
		System.out.println("putki transfer " + " cont in stuff " + sin + " out room left " + rl + " siirto " + c);
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
		
	// sets everything ready for transfer
	public synchronized boolean prepare(String name, T in, T out, boolean filler, boolean drain) {
		System.out.println("putki prepare");
		if(inUse)
			return false;
		if(in == null || out == null)
			return false;
		System.out.println("putki validing");
		if(!in.validateUser(name) || !out.validateUser(name))
			return false;
		System.out.println("putki connecting");
		if(!in.connect(true))
			return false;
		if(!out.connect(false))
			return false;
		usingFiller = filler;
		usingDrain = drain;
		System.out.println("putki init success");
		inUse = true;
		in.startTransfer(false);
		out.startTransfer(true);
		user = name;
		contIn = in;
		contOut = out;
		startFlag = true;
		return true;
	}
	
	// handles the whole transfer process 
	private void work() {
		System.out.println("putki working");
	
		while(transfer(speed)) {
			try {
				Thread.sleep(1000);
			} catch(Exception t) {}
		}
		contIn.stopTransfer();
		if(contIn.getStuff() == 0 || usingFiller)
			contIn.free(user);
		contOut.stopTransfer();
		if(usingDrain)
			contOut.free(user);
		inUse = false;
		startFlag = false;
	}
	
	
	public void run() {
		System.out.println("LOADER thread start");
		while(!end) {
			if(startFlag) {
				System.out.println("LOADER startFlag true");
				work();
				startFlag = false;
			}
		}
		System.out.println("LOADER thread stop");
	}
}
