package download;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Warehouse extends Remote {
	
	String getProductsList() throws RemoteException;

	String searchForProducts(String string) throws RemoteException;

	void addProduct(Produkt product) throws RemoteException;
	
	boolean checkForProducts(String lancuch) throws RemoteException;
	
	boolean buyProduct(int id) throws RemoteException;

}
