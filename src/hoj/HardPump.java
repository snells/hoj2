package hoj;

public class HardPump<T extends Container> extends TransferPump<T> {

	private int transferCount;
	public HardPump() {
		speed = 500;
	}
	
	public void setCount(int n) {
		if(n < 0) {
			transferCount = Integer.MAX_VALUE;
			speed = 500;
		} else if(n < 500) {
			transferCount = n;
			speed = n;
		}
		else {
			speed = 500;
			transferCount = n;
		}

	}
	
	@Override
	protected boolean extraTest() {
		if(transferCount <= 0)
			return true;
		transferCount -= speed;
		return false;
	}
}
