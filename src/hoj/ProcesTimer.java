package hoj;

public class ProcesTimer extends Thread {
	private Processor p;
	private int time;
	public ProcesTimer(Processor proc, int n) {
		p = proc;
		time = n;
	}
	
	public void start() {
		try {
			Thread.sleep(time * 1000);
		} catch(Exception e) {}
		p.procesFinish();
	}

}
