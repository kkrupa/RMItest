package download;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Warehouse extends Remote {
	
	ArrayList<Produkt> getProductsList() throws RemoteException;

	ArrayList<Produkt> searchForProducts(String string) throws RemoteException;

	void addProduct(Produkt product) throws RemoteException;
	
	boolean checkForProducts(String lancuch) throws RemoteException;
}
