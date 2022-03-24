package dk.via.math.client;

import dk.via.math.model.Expression;
import dk.via.math.model.Result;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class MathClientImplementation implements MathClient {
    public MathClientImplementation(String host, int port) throws RemoteException, NotBoundException {
    }

    @Override
    public double add(double operand1, double operand2) throws IOException {
        Expression expression = new Expression("+", operand1, operand2);
        Result result = math.evaluate(expression);
        return result.getValue();
    }

    @Override
    public double subtract(double operand1, double operand2) throws IOException {
        Expression expression = new Expression("-", operand1, operand2);
        Result result = math.evaluate(expression);
        return result.getValue();
    }

    @Override
    public double multiply(double operand1, double operand2) throws IOException {
        Expression expression = new Expression("*", operand1, operand2);
        Result result = math.evaluate(expression);
        return result.getValue();
    }

    @Override
    public double divide(double operand1, double operand2) throws IOException {
        Expression expression = new Expression("/", operand1, operand2);
        Result result = math.evaluate(expression);
        return result.getValue();
    }
}
