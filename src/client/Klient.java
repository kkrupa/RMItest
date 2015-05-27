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
	
	public static Warehouse r;
	private String url = "magazyn";
	
	public Klient() throws MalformedURLException, RemoteException, NotBoundException {
		r = (Warehouse)Naming.lookup(url);
	}

	public String getListaProduktow() throws RemoteException {
		return r.getProductsList().toString();
	}
	
	public String szukajProduktu(String lancuch) throws RemoteException {
		return r.searchForProducts(lancuch).toString();
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
