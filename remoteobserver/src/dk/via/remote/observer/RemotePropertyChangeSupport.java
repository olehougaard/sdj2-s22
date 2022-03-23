package dk.via.remote.observer;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
import java.util.Objects;
import java.util.stream.Stream;

public class RemotePropertyChangeSupport<Value extends Serializable> {
    private static class ListenerProxy<Value extends Serializable> {
        private final String propertyName;
        private final RemotePropertyChangeListener<Value> listener;

        public ListenerProxy(String propertyName, RemotePropertyChangeListener<Value> listener) {
            this.propertyName = propertyName;
            this.listener = listener;
        }

        public ListenerProxy(RemotePropertyChangeListener<Value> listener) {
            this(null, listener);
        }

        public boolean acceptsProperty(String propertyName) {
            return this.propertyName == null || this.propertyName.equals(propertyName);
        }

        public void propertyChange(RemotePropertyChangeEvent<Value> evt) throws RemoteException {
            if (acceptsProperty(evt.getPropertyName())) {
                listener.propertyChange(evt);
            }
        }

        public RemotePropertyChangeListener<Value> getListener() {
            return listener;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ListenerProxy<?> that = (ListenerProxy<?>) o;
            return Objects.equals(propertyName, that.propertyName) && listener.equals(that.listener);
        }

        @Override
        public int hashCode() {
            return Objects.hash(propertyName, listener);
        }
    }

    private final UnicastRemoteObject sourceBean;
    private final LinkedList<ListenerProxy<Value>> listeners;

    public RemotePropertyChangeSupport(UnicastRemoteObject sourceBean) {
        this.sourceBean = sourceBean;
        this.listeners = new LinkedList<>();
    }

    public synchronized void addPropertyChangeListener(RemotePropertyChangeListener<Value> listener) {
        listeners.add(new ListenerProxy<>(listener));
    }

    public synchronized void addPropertyChangeListener(String propertyName, RemotePropertyChangeListener<Value> listener) {
        if (propertyName == null) return;
        listeners.add(new ListenerProxy<>(propertyName, listener));
    }

    public synchronized void removePropertyChangeListener(RemotePropertyChangeListener<Value> listener) {
        listeners.remove(new ListenerProxy<>(listener));
    }

    public synchronized void removePropertyChangeListener(String propertyName, RemotePropertyChangeListener<Value> listener) {
        if (propertyName == null) return;
        listeners.remove(new ListenerProxy<>(propertyName, listener));
    }

    public void firePropertyChange(RemotePropertyChangeEvent<Value> evt) throws RemoteException {
        if (Objects.equals(evt.getOldValue(), evt.getNewValue())) return;
        synchronized(this) {
            for(ListenerProxy<Value> proxy: listeners) {
                proxy.propertyChange(evt);
            }
        }
    }

    public void firePropertyChange(String propertyName, Value oldValue, Value newValue) throws RemoteException {
        firePropertyChange(new RemotePropertyChangeEvent<>(sourceBean, propertyName, oldValue, newValue));
    }

    @SuppressWarnings("unchecked")
    private RemotePropertyChangeListener<Value>[] toArray(Stream<ListenerProxy<Value>> stream) {
        return stream.map(ListenerProxy::getListener).toArray(RemotePropertyChangeListener[]::new);
    }

    public RemotePropertyChangeListener<Value>[] getPropertyChangeListeners() {
        return toArray(listeners.stream());
    }

    public RemotePropertyChangeListener<Value>[] getPropertyChangeListeners(String propertyName) {
        return toArray(listeners.stream().filter(proxy -> proxy.acceptsProperty(propertyName)));
    }

    public boolean hasListeners(String propertyName) {
        return listeners.stream().anyMatch(proxy -> proxy.acceptsProperty(propertyName));
    }
}
