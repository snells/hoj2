package hoj;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerInter extends Remote  {
	
	
	
boolean login(Client c) throws RemoteException;
boolean loaderStart(Client c) throws RemoteException ;
boolean siloReserve(Client c, int num)throws RemoteException;
boolean siloPumpStart(Client c, int num)throws RemoteException;
boolean processorReserve(Client c, int num)throws RemoteException;
boolean processorStart(Client c, int num)throws RemoteException;
boolean pumpStart(Client c, int num) throws RemoteException;
boolean tankReserve(Client c, int num) throws RemoteException;
boolean bottlePumpStart(Client c, int num) throws RemoteException;

}
