package server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

import javax.naming.NamingException;

import download.Warehouse;

public class ServerService {
	public static void main(String[] args) throws RemoteException,
			NamingException {
		System.out.println("Uruchamianie serwera testowego...");
		Warehouse magazynGlowny = new Magazyn();

		try {
			Naming.rebind("magazyn", magazynGlowny);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		System.out.println("Oczekiwanie na wywolania klientow...");

	}
}
