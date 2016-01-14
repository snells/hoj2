package hoj;

public class Processor extends Container implements Runnable {
	private volatile boolean procesFlag;
	private boolean end = false;
	private volatile boolean startFlag = false;

	public Processor(int n) {
		super(n, "", 2000);
		procesState = "waiting";
		procesFlag = false;
		new Thread(this).start();
		
	}
	
	public boolean procesReady() {
		return procesFlag;
	}
	
	public boolean procesStart() {
		System.out.println("PROCESSOR start");
		if(procesFlag || inUse || roomLeft() > 0)
			return false;
		inUse = true;
		procesState = "processing";
		procesFlag = false;
		System.out.println("PROCESSOR timer start");
		startFlag = true;
		//timer = new ProcesTimer(this, 5);
		//timer.start();
		return true;
	}

	public void procesFinish() {
		startFlag = false;
		procesState = "ready";
		procesFlag = true;
		inUse = false;
	
	}
	@Override
	public boolean free(String name) {
		if(inUse)
			return false;
		if(!name.equals(user))
			return false;
		procesState = "waiting";
		procesFlag = false;
		reserved = false;
		user = "";
		inUse = false;
		return true;
	}
	
	public void run() {
		while(!end) {
			if(startFlag) {
				try {
					Thread.sleep(20000);
				} catch(Exception e) {}
				procesFinish();
			}
		}
	}
}





/*
private volatile boolean procesFlag;
private ProcesTimer timer;
public Processor(int n) {
	super(n, "", 2000);
	procesState = "waiting";
	procesFlag = false;
	
}

public boolean procesReady() {
	return procesFlag;
}

public boolean procesStart() {
	System.out.println("PROCESSOR start");
	if(procesFlag || inUse || roomLeft() > 0)
		return false;
	inUse = true;
	procesState = "processing";
	procesFlag = false;
	System.out.println("PROCESSOR timer start");
	timer = new ProcesTimer(this, 5);
	timer.start();
	return true;
}

public void procesFinish() {
	procesState = "ready";
	procesFlag = true;
	inUse = false;

}
@Override
public boolean free(String name) {
	if(inUse)
		return false;
	if(!name.equals(user))
		return false;
	procesState = "waiting";
	procesFlag = false;
	reserved = false;
	user = "";
	inUse = false;
	return true;
}
*/


