package dk.via.calculator.model;

import dk.via.calculator.client.MathClient;

import java.beans.PropertyChangeSupport;
import java.io.IOException;

public class ModelManager implements Model {
    private final MathClient client;

    public ModelManager(MathClient client) {
        this.client = client;
    }

    @Override
    public double add(double a, double b) throws IOException {
        return client.plus(a, b);
    }

    @Override
    public double subtract(double a, double b) throws IOException {
        return client.minus(a, b);
    }

    @Override
    public double multiply(double a, double b) throws IOException {
        return client.times(a, b);
    }

    @Override
    public double divide(double a, double b) throws IOException {
        return client.divide(a, b);
    }
}
