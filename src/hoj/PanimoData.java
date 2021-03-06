package hoj;

import java.io.Serializable;

// used to get the panimo state to client
public class PanimoData implements Serializable {

	private static final long serialVersionUID = 6385575812664281133L;
	public ContainerData[] silos;
	public ContainerData[] processors;
	public ContainerData[] tanks;
	public boolean loader;
	public boolean[] siloPumps;
	public boolean[] pumps;
	public boolean[] bottlePumps;
	
	public PanimoData(
			ContainerData[] s,
			ContainerData[] p,
			ContainerData[] t,
			boolean l,
			boolean[] sps,
			boolean[] ps,
			boolean[] bps) {
		silos = s;
		processors = p;
		tanks = t;
		loader = l;
		siloPumps = sps;
		pumps = ps;
		bottlePumps = bps;
	}

}
