package dk.via.remote.observer;

import java.io.Serializable;

public class RemotePropertyChangeEvent<Value extends Serializable> implements Serializable {
    private final Serializable source;
    private final String propertyName;
    private final Value oldValue;
    private final Value newValue;

    public RemotePropertyChangeEvent(Serializable source, String propertyName, Value oldValue, Value newValue) {
        this.source = source;
        this.propertyName = propertyName;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    public Serializable getSource() {
        return source;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public Value getOldValue() {
        return oldValue;
    }

    public Value getNewValue() {
        return newValue;
    }

    @Override
    public String toString() {
        return "RemotePropertyChangeEvent{" +
                "source=" + source +
                ", propertyName='" + propertyName + '\'' +
                ", oldValue=" + oldValue +
                ", newValue=" + newValue +
                '}';
    }
}
