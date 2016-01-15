package hoj;


// transfers from processors to tanks 
public class LiquidPump<T extends Container> extends TransferPump<T> {
	

	public LiquidPump() {
		speed = 200;
	}
}
