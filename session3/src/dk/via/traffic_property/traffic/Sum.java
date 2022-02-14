package dk.via.traffic_property.traffic;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Sum {
    private int a;
    private int b;
    private PropertyChangeSupport support;

    public Sum(int a, int b) {
        this.a = a;
        this.b = b;
        this.support = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(propertyName, listener);
    }

    public void removePropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(propertyName, listener);
    }

    public void setA(int a) {
        int sum = getSum();
        int oldValue = a;
        this.a = a;
        support.firePropertyChange("a", oldValue, a);
        support.firePropertyChange("sum", sum, getSum());
    }

    public void setB(int b) {
        int sum = getSum();
        this.b = b;
        support.firePropertyChange("sum", sum, getSum());
    }

    public int getSum() {
        return a + b;
    }
}
