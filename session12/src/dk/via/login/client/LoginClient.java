package dk.via.login.client;

import dk.via.login.shared.User;

import java.io.IOException;

public interface LoginClient {
    boolean login(String username, String password) throws IOException;

    User createUser(String username, String password, String name) throws IOException;

    void updatePassword(String username, String password) throws IOException;
}
