package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.naming.NamingException;

import download.Produkt;
import download.Warehouse;

public class Klient {

	public static void main(String[] args) throws NamingException,
			RemoteException, MalformedURLException, NotBoundException {

		String url = "magazyn";
		Warehouse r = (Warehouse)Naming.lookup(url);
		ArrayList<Produkt> lista = new ArrayList<Produkt>();
		lista = r.getProductsList();
		System.out.println(r.checkForProducts("melex"));
		System.out.println(lista.toString());
		

		
		
	}

}
