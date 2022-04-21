package dk.via.exercise10_2.client;

import java.io.IOException;
import java.rmi.NotBoundException;

public class StartClient {
    public static void main(String[] args) throws IOException, NotBoundException {
        LoginClient client = new LoginClientImplementation("localhost", 8888);
        System.out.println(client.login("Administrator", "abcd1234"));
        client.close();
    }
}
