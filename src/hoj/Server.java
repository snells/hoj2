package hoj;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Server extends Remote {
	
	
	
boolean login(String n) throws RemoteException;
boolean loaderStart(String n) throws RemoteException ;
boolean siloReserve(String n, int num)throws RemoteException;
boolean siloPumpStart(String n, int num, int count)throws RemoteException;
boolean processorReserve(String n, int num)throws RemoteException;
boolean processorStart(String n, int num)throws RemoteException;
boolean pumpStart(String n, int num) throws RemoteException;
boolean tankReserve(String n, int num) throws RemoteException;
boolean bottlePumpStart(String n, int num) throws RemoteException;
boolean siloFree(String n, int num) throws RemoteException;
boolean processorFree(String n, int num) throws RemoteException;
boolean tankFree(String n, int num) throws RemoteException;
PanimoData getData()  throws RemoteException;
}
