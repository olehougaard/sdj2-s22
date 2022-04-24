package dk.via.login.server;

import dk.via.log.DefaultLog;
import dk.via.login.shared.Login;
import dk.via.login.shared.User;

import java.io.IOException;
import java.rmi.RemoteException;

public class LoggerProxy implements Login {
    private final Login login;
    private final DefaultLog log;

    public LoggerProxy(Login login) {
        this.login = login;
        this.log = DefaultLog.getInstance();
    }

    public boolean login(String username, String password) throws RemoteException {
        try {
            log.log(username + " logged in.");
        } catch (IOException e) {
            throw new RemoteException(e.getMessage(), e);
        }
        return login.login(username, password);
    }

    public User createUser(String username, String password, String name) throws RemoteException {
        return login.createUser(username, password, name);
    }

    public void updatePassword(String username, String password) throws RemoteException {
        login.updatePassword(username, password);
    }
}
