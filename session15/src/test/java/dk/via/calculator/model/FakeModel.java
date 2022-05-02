package dk.via.calculator.model;

import java.io.IOException;

public class FakeModel implements Model {
    private final Calculator calculator;

    public FakeModel() {
        calculator = new Calculator();
    }

    @Override
    public double add(double a, double b) throws IOException {
        return calculator.add(a, b);
    }

    @Override
    public double subtract(double a, double b) throws IOException {
        return calculator.subtract(a, b);
    }

    @Override
    public double multiply(double a, double b) throws IOException {
        return calculator.multiply(a, b);
    }

    @Override
    public double divide(double a, double b) throws IOException {
        return calculator.divide(a, b);
    }
}
