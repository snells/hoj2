package hoj;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientInter extends Remote {
	
public String getName() throws RemoteException;
}