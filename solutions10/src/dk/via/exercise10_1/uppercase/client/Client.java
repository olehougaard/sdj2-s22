package dk.via.exercise10_1.uppercase.client;

import dk.via.exercise10_1.uppercase.server.Uppercase;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    // Use interface not server class
    private final Uppercase uppercase;

    public Client(String host, int port) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(host, port);
        // Cast to interface not server class
        uppercase = (Uppercase) registry.lookup("uppercase");
    }

    public String uppercase(String source) throws RemoteException {
        return uppercase.uppercase(source);
    }
}
