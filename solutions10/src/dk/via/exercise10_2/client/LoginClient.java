package dk.via.exercise10_2.client;

import java.io.Closeable;
import java.io.IOException;

public interface LoginClient extends Closeable {
    boolean login(String username, String password) throws IOException;
}
