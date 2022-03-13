package dk.via.objectstream;

import java.io.*;
import java.net.Socket;

public class MathCommunicator implements Runnable {
    private final Socket socket;

    public MathCommunicator(Socket socket) {
        this.socket = socket;
    }

    private void communicate() throws IOException {
        try {
            InputStream inputStream = socket.getInputStream();

            OutputStream outputStream = socket.getOutputStream();

            ObjectInputStream input = new ObjectInputStream(inputStream);
            ObjectOutputStream output = new ObjectOutputStream(outputStream);

            loop: while(true) {
                Expression request = (Expression) input.readObject();
                String operator = null;
                double a = 0;
                double b = 0;
                switch (operator) {
                    case "+": {
                        Result result = new Result(a + b);
                        break;
                    }
                    case "-": {
                        Result result = new Result(a - b);
                        break;
                    }
                    case "exit":
                        break loop;
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            socket.close();
        }
    }

    @Override
    public void run() {
        try {
            communicate();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
