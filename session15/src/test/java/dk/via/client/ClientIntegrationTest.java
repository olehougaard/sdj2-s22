package dk.via.client;

import dk.via.calculator.client.MathClientImplementation;
import dk.via.calculator.server.MathServer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class ClientIntegrationTest {

    private MathClientImplementation client;

    private static Thread serverThread(int port) throws IOException {
        Thread serverThread = new Thread(new MathServer(port));
        serverThread.setDaemon(true); // Will not keep the program running.
        return serverThread;
    }

    @BeforeAll
    static void startServer() throws IOException {
        Thread serverThread = serverThread(8888);
        serverThread.start();
    }

    @BeforeEach
    public void setUp() throws IOException {
        client = new MathClientImplementation("localhost", 8888);
    }

    @Test
    public void add_calls_server_and_gets_result() throws IOException {
        assertEquals(4.0, client.plus(2, 2));
    }

    @Test
    public void creating_client_for_wrong_port_throws_IOException() {
        assertThrows(IOException.class, () -> new MathClientImplementation("localhost", 9999));
    }

    @Test
    public void calling_add_throws_IOException_if_the_communication_is_closed() throws IOException {
        client.close();
        assertThrows(IOException.class, () -> client.plus(2, 2));
    }

    @Test
    public void test() throws Exception {
        MathServer mathServer = new MathServer(9999);
        Thread serverThread = new Thread(mathServer);
        serverThread.start();
        MathClientImplementation client9999 = new MathClientImplementation("localhost", 9999);
        mathServer.stop();
        serverThread.join();
        assertThrows(IOException.class, () -> client9999.plus(2, 2));
    }
    // and so on ...
}
