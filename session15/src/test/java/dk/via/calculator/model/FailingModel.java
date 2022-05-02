package dk.via.calculator.model;

import java.io.IOException;

public class FailingModel implements Model {
    @Override
    public double add(double a, double b) throws IOException {
        throw new IOException();
    }

    @Override
    public double subtract(double a, double b) throws IOException {
        throw new IOException();
    }

    @Override
    public double multiply(double a, double b) throws IOException {
        throw new IOException();
    }

    @Override
    public double divide(double a, double b) throws IOException {
        throw new IOException();
    }
}
