package dk.via.exercise10_1.uppercase.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Uppercase extends Remote {
    String uppercase(String source) throws RemoteException; // Added throws
}
