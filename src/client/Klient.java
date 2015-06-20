package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.naming.NamingException;

import sun.security.action.GetLongAction;
import download.Produkt;
import download.Warehouse;

public class Klient {
	
	public static Warehouse remote;
	private String url = "magazyn";
	
	public Klient() throws MalformedURLException, RemoteException, NotBoundException {
		remote = (Warehouse)Naming.lookup(url);
	}

	public String getListaProduktow() throws RemoteException {
		return remote.getProductsList();
	}
	
	public String szukajProduktu(String lancuch) throws RemoteException {
		return remote.searchForProducts(lancuch);
	}
	
	public boolean kupProdukt(int id) throws RemoteException {
		return remote.buyProduct(id);
	}
	
	public static void main(String[] args) {
		
		try {
			MainWindow window = new MainWindow(new Klient());
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
