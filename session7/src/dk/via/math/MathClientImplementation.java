package dk.via.math;

import java.io.*;
import java.net.Socket;

public class MathClientImplementation implements MathClient {
    private final Socket socket;

    public MathClientImplementation(String host, int port) throws IOException {
        this.socket = new Socket(host, port);
        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();
    }

    @Override
    public double plus(double operand1, double operand2) throws IOException {
        return 0;
    }

    @Override
    public void close() throws IOException {
        socket.close();
    }
}
