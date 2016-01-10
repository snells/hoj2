package hoj;

import java.rmi.Remote;

public interface ClientInter extends Remote {
	
void updateSilo(ContainerData d, int num);
void updateLoader();
void updateSiloPump(int num);
void updateProcessor(ContainerData d, int num);
void updateTank(ContainerData d, int num);
void UpdateBottlePump(int num); 

}