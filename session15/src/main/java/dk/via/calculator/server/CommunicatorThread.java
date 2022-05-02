package dk.via.calculator.server;

import dk.via.calculator.server.MathCommunicator;

import java.io.IOException;
import java.net.Socket;

public class CommunicatorThread extends Thread {
    private final MathCommunicator communicator;

    public CommunicatorThread(Socket socket) {
        communicator = new MathCommunicator(socket);
    }

    @Override
    public void run() {
        communicator.run();
    }

    public void halt() throws IOException, InterruptedException {
        communicator.stop();
        join();
    }
}
