package dk.via.calculator.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MathServer implements Runnable {
    private final ServerSocket serverSocket;
    private boolean running;
    private final ArrayList<CommunicatorThread> communicators;

    public MathServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        running = true;
        System.out.println("Server is ready for input port 8888");
        communicators = new ArrayList<>();
    }

    public void listen() throws IOException {
        while(running) {
            Socket socket = serverSocket.accept();
            CommunicatorThread communicatorThread = new CommunicatorThread(socket);
            communicators.add(communicatorThread);
            communicatorThread.start();
        }
    }

    public void run() {
        try {
            listen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop() throws IOException, InterruptedException {
        running = false;
        serverSocket.close();
        for(CommunicatorThread communicator: communicators) {
            communicator.halt();
        }
    }

    public static void main(String[] args) throws IOException {
        MathServer mathServer = new MathServer(8888);
        mathServer.run();
    }
}
