package dk.via.math;

import java.io.Closeable;
import java.io.IOException;

public interface MathClient extends Closeable {
    double plus(double operand1, double operand2) throws IOException;
}
