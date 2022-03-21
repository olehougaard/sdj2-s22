package dk.via.calculator.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ModelManager implements Model {
    private final Calculator calculator;
    private final PropertyChangeSupport support;

    public ModelManager() {
        this.calculator = new Calculator();
        this.support = new PropertyChangeSupport(this);
    }

    @Override
    public double add(double a, double b) {
        return calculator.add(a, b);
    }

    @Override
    public double subtract(double a, double b) {
        return calculator.subtract(a, b);
    }

    @Override
    public double multiply(double a, double b) {
        return calculator.multiply(a, b);
    }

    @Override
    public double divide(double a, double b) {
        return calculator.divide(a, b);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }
}
