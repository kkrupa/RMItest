# RMItest

Projekt potrzebuje biblioteki SWT.

To run do the following:

1. Start rmi registry in your root folder - it should not contain any .class files
command: rmiregistry -J-Djava.rmi.server.codebase="http://localhost:8080/"

2. Start HTTP server (port 8080)

3. Run ServerService in server package to start a server (in Eclipse for example)

4. Run Klient in client package to start the client application

Features:
- simple product listing
- simple product search (by name/manufacturer)
- buy product

The products are created and populated in constructor of Magazyn class.
