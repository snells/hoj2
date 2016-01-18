package hoj;

// pump that transfers stuff to silos and from silos
public class HardPump<T extends Container> extends TransferPump<T> {

	private int transferCount;
	public HardPump() {
		speed = 500;
	}
	
	// client specified transfer count or everything
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
	
	// tests that we don't transfer more than the user specified
	@Override
	protected boolean extraTest() {
		if(transferCount <= 0)
			return true;
		transferCount -= speed;
		return false;
	}
}
