package dk.via.exercise10_2.client;

import dk.via.exercise10_2.shared.Login;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class LoginClientImplementation implements LoginClient {
    private final Login login;

    public LoginClientImplementation(String host, int port) throws IOException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(Registry.REGISTRY_PORT);
        login = (Login) registry.lookup("login");
    }

    @Override
    public boolean login(String username, String password) throws IOException {
        return login.login(username, password);
    }

    @Override
    public void close() throws IOException {
    }
}
