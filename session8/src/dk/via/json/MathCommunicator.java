package dk.via.json;

import com.google.gson.Gson;

import java.io.*;
import java.net.Socket;

public class MathCommunicator implements Runnable {
    private final Socket socket;
    private final Gson gson;

    public MathCommunicator(Socket socket) {
        this.socket = socket;
        this.gson = new Gson();
    }

    private void communicate() throws IOException {
        try {
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            BufferedReader input = new BufferedReader(new InputStreamReader(inputStream));
            PrintWriter output = new PrintWriter(outputStream);

            loop: while(true) {
                String operator = null;
                double a = 0;
                double b = 0;
                switch (operator) {
                    case "+": {
                        Result r = new Result(a + b);
                        break;
                    }
                    case "-": {
                        Result r = new Result(a - b);
                        break;
                    }
                    case "exit":
                        System.out.println("Exiting");
                        break loop;
                }
            }
        } finally {
            socket.close();
        }
    }

    @Override
    public void run() {
        try {
            communicate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
