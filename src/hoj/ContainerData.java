package hoj;

import java.io.Serializable;

public class ContainerData implements Serializable {
	protected int index;
	protected String type;
	protected long stuff;
	protected long maxStuff;
	protected boolean reserved;
	protected String user;
	protected boolean inUse;
	protected boolean fill;
	public String procesState;
	
	
	public ContainerData(int index, String type, long stuff, long maxStuff, boolean reserved, String user,
			boolean inUse, boolean fill, String procesState) {
		this.index = index;
		this.type = type;
		this.stuff = stuff;
		this.maxStuff = maxStuff;
		this.reserved = reserved;
		this.user = user;
		this.inUse = inUse;
		this.fill = fill;
		this.procesState = procesState;
	}
	public ContainerData() {}

}
