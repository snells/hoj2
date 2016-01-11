package hoj;

import java.util.ArrayList;
import java.util.HashMap;

public class Panimo {
	
		private HardPump loader;
		private Silo[] silos;
		private HardPump[] siloPumps;
		private Processor[] processors;
		private LiquidPump[] pumps;
		private Tank[] tanks;
		private LiquidPump[] bottlePumps;
		private ArrayList<String> clients;
	
	
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
	public Panimo() {
		
	}


	public boolean login(String name)  {
		if(loggedIn(name))
			return false;
		clients.add(name);
		return true;
	}
	
		public boolean loaderStart(String name)  {
			
			return false;
	}
		public boolean siloReserve(String name, int num)  {
				return false;
	}
		public boolean siloPumpStart(String name, int num)  {
		return false;
	}
		public boolean processorReserve(String name, int num) {
			return false;
	}
		public boolean processorStart(String name, int num) {
			return false;
	}
		public boolean pumpStart(String name, int num) {
			return false;
	}
		public boolean tankReserve(String name, int num)  {
			return false;
	}
	public boolean bottlePumpStart(String name, int num)  {
		return false;
	}
}
