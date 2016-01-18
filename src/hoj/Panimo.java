package hoj;

import java.util.ArrayList;

// controls the pumps and containers 
@SuppressWarnings({"unchecked", "rawtypes"})
public class Panimo {
	
		private Container filler = new Container(-1, "", Long.MAX_VALUE);
		private Container[] drains; 
		private volatile HardPump loader;
		private Silo[] silos;
		private HardPump[] siloPumps;
		private Processor[] processors;
		private LiquidPump[] pumps;
		private Tank[] tanks;
		private LiquidPump[] bottlePumps;
		private ArrayList<String> clients;
	
	
	
		
		public Panimo() {
			silos = new Silo[4];
			loader = new HardPump();
			siloPumps = new HardPump[2];
			siloPumps[0] = new HardPump();
			siloPumps[1] = new HardPump();
			processors = new Processor[3];
			pumps = new LiquidPump[2];
			pumps[0] = new LiquidPump();
			pumps[1] = new LiquidPump();
			tanks = new Tank[10];
			bottlePumps = new LiquidPump[2];
			bottlePumps[0] = new LiquidPump();
			bottlePumps[1] = new LiquidPump();
			for(int x = 0; x < 10; x++) {
				if(x < 4)
					silos[x] = new Silo(x);
				if(x < 3)
					processors[x] = new Processor(x);
				tanks[x] = new Tank(x);
			}
			clients = new ArrayList<String>();
			for(int x = 0; x < 2; x++) {
				if(x < 1)
					loader.start();
					
				siloPumps[x].start();
				pumps[x].start();
				bottlePumps[x].start();
			}
			drains = new Container[2];
			drains[0] = new Container(-2, "", Long.MAX_VALUE);
			drains[1] = new Container(-3, "", Long.MAX_VALUE);
		}
	
	public LiquidPump getPump(int n) {
		if( pumps.length > n || n < 0)
			return null;
		return pumps[n];
	}
	public boolean loggedIn(String s) {
		for(String n : clients) {
			if(s.equals(n))
				return true;
		}
		return false;
	}
	
	public ArrayList<Silo> clientsSilos(String name)  {
		ArrayList<Silo> s = new ArrayList<Silo>();
		if(!loggedIn(name))
			return s;
		for(int x = 0; x < silos.length; x++) {
			if(silos[x].getUser().equals(name))
				s.add(silos[x]);
		}
		return s;
	}
	
	public ArrayList<Processor> clientsProcessors(String name) {
		ArrayList<Processor> s = new ArrayList<Processor>();
		if(!loggedIn(name))
			return s;
		for(int x = 0; x < processors.length; x++) {
			if(processors[x].getUser().equals(name))
				s.add(processors[x]);
		}
		return s;
	}
	
	public ArrayList<Tank> clientsTanks(String name) {
		ArrayList<Tank> s = new ArrayList<Tank>();
		if(!loggedIn(name))
			return s;
		for(int x = 0; x < tanks.length; x++) {
			if(tanks[x].getUser().equals(name))
				s.add(tanks[x]);
		}
		return s;
	}
	
	
	private ContainerData[] silosData() {
		ContainerData[] d = new ContainerData[silos.length];
		for(int x = 0; x < silos.length; x++) {
			d[x] = silos[x].toData();
		}
		return d;
	}
	private ContainerData[] processorsData() {
		ContainerData[] d = new ContainerData[processors.length];
		for(int x = 0; x < processors.length; x++) {
			d[x] = processors[x].toData();
		}
		return d;
	}
	
	private ContainerData[] tanksData() {
		ContainerData[] d = new ContainerData[tanks.length];
		for(int x = 0; x < tanks.length; x++) {
			d[x] = tanks[x].toData();
		}
		return d;
	}
	
	public PanimoData getData() {
		return new PanimoData(
				silosData(),
				processorsData(),
				tanksData(),
				loader.isFree(),
				new boolean[] { siloPumps[0].isFree(), siloPumps[1].isFree() },
				new boolean[] { pumps[0].isFree(), pumps[1].isFree() },
				new boolean[] { bottlePumps[0].isFree(), bottlePumps[1].isFree() });
				
	}
	
	

	public boolean login(String name)  {
		if(loggedIn(name))
			return false;
		clients.add(name);
		return true;
	}
	
		
	public boolean loaderStart(String name)  {
			if(!filler.reserve(name))
				return false;		
			filler.stuff = 40000;
			ArrayList<Silo> ct = clientsSilos(name);
			if(ct.size() < 1) 
				return false;
			for(Silo t : ct) {
				if(t.full())
					continue;
				loader.setCount(-1);
				boolean ret = loader.prepare(name, filler, t, true, false);
				if(ret) return ret;
			}
			return false;			
	}
		public boolean siloReserve(String name, int num)  {
			System.out.println("Reserving silo");
				return silos[num].reserve(name);
	}

		public boolean siloFree(String name, int num)  {
			return silos[num].free(name);
	}
		
	
		public boolean siloPumpStart(String name, int num, int count)  {
			System.out.println("PANIMO silo pump start");
			ArrayList<Silo> ct = clientsSilos(name);
			ArrayList<Processor> cp = clientsProcessors(name);
			// haetaan siilo josta voi ottaa
			if(ct.size() < 1) 
				return false;
			Silo s = null;
			for(Silo t : ct) {
				if(t.getStuff() == 0 || t.inUse)
					continue;
				s = t;
				break;
			}
			// haetaan vapaa keitin
			Processor p = null;
			for(Processor t : cp) {
				if(t.procesReady() || t.inUse || t.roomLeft() == 0)
					continue;
				p = t;
				break;
			}
			
			// jos ei vapaita ja sinulle varattuja niin lopetetaan
			if(s == null || p == null)
				return false;
			
			// onko pumppu vapaa?
			HardPump sp = siloPumps[num];
				if(sp.inUse)
					return false;
			
			sp.setCount(count);
			return sp.prepare(name, s, p, false, false); 
			
		}
		
		
		public boolean processorReserve(String name, int num) {
			System.out.println("Reserving processor");
			return processors[num].reserve(name);
	}
		public boolean processorStart(String name, int num) {
			Processor p = processors[num];
			if(p.inUse || !p.validateUser(name))
				return false;
			return p.procesStart();
	}
		public boolean processorFree(String name, int num) {
			return processors[num].free(name);
	}
		
		public boolean pumpStart(String name, int num) {
			System.out.println("PANIMO pump start");
			ArrayList<Processor> cp = clientsProcessors(name);
			ArrayList<Tank> ct = clientsTanks(name);
			if(cp.size() < 1) 
				return false;
			Processor p = null;
			for(Processor t : cp) {
				if(!t.procesReady() || t.inUse)
					continue;
				p = t;
			}
			Tank t = null;
			for(Tank a : ct) {
				if(a.roomLeft() == 0 || a.inUse)
					continue;
				t = a;
			}
			if(p == null || t == null)
				return false;
			
			LiquidPump lp = pumps[num];
				if(lp.inUse)
					return false;
			return lp.prepare(name, p, t, false, false); 
			
		}
		
		public boolean tankReserve(String name, int num) {
			System.out.println("Reserving tank");
			return tanks[num].reserve(name);
	}
		public boolean tankFree(String name, int num) {
			return tanks[num].free(name);
	}
	public boolean bottlePumpStart(String name, int num)  {
		if(!drains[num].reserve(name))
			return false;		
		drains[num].stuff = 0;
		ArrayList<Tank> ct = clientsTanks(name);
		if(ct.size() < 1) 
			return false;
		Tank in = null;
		for(Tank t : ct) {
			if(t.getStuff() == 0 || t.inUse)
				continue;
			in = t;
			break;
		}
		if(in == null)
			return false;
		return bottlePumps[num].prepare(name, in, drains[num], false, true);
	}
}
