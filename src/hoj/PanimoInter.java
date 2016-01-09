package hoj;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface PanimoInter extends Remote {
	
	/* toteuta miten halut, vaan esimerkki
	// tuo raaka-aineet siiloihin, ruuvikuljetin
	SiloPump loader;
	
	// 4
	Silo[] silos;
	
	//2
	SiloPump[] jakajat;
	
	//3 keittimet
	Processor[] processors;
	
	//2 pumput
	Pump[] pumps;
	
	//10 kypsytys
	Tank[] tanks;
	
	//2 pullotus pumput
	Pump[] botllePumps;
	
	HashTable Client
	*/
	
	// jos tointo kesken 
	void loaderStart();
	
	
}
