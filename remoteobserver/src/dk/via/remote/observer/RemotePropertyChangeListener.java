package dk.via.remote.observer;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.EventListener;

public interface RemotePropertyChangeListener<Value extends Serializable> extends Remote, EventListener {
    void propertyChange(RemotePropertyChangeEvent<Value> evt) throws RemoteException;
}
