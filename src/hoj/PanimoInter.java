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
	
	/* jos toiminto kesken false
	   jos siiloa ei varattu hae raaka-aineita
	   jos siilo varattu dumppaa raaka-aineita siiloon
	   */
	boolean loaderStart(Client c);
	
	// jos jo varattu false
	boolean reserveSilo(Client c, int num);
	
	// jos toiminto kesken tai 
	// jos asiakkaalla ei ole siiloa tai prosessoria varattu
	// niin false
	boolean startSiloPump(Client c, int num);
	
	// jos ei varattu false
	// jos ei ole ladattu false
	boolean startProcessor(Client c, int num);
	
	// jos varattu false
	// jos ei prosessori valmis tai ei varattu tankkia niin false
	boolean startPump(Client c, int num);
	
	
	boolean reserveTank(Client c, int num);
	
	// jos toiminto kesken false
	// jos ei varattu tankki niin false
	boolean startBottlePump(Client c, int num);
	
	// clientti kyselee panimon tilaa
	boolean inUseLoader();
	boolean inUseSilo(int n);
	boolean inUseSiloPump(int n);
	boolean inUseProcessor(int n);
	boolean inUsePump(int n);
	boolean inUseTank(int n);
	boolean inUseBottlePump(int n);

}


