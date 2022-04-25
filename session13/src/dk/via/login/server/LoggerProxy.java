package dk.via.login.server;

import dk.via.log.DefaultLog;
import dk.via.login.shared.Login;
import dk.via.login.shared.User;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;

public class LoggerProxy implements Login {
    private final Login login;
    private BlockingQueue<String> queue;
    private final DefaultLog log;

    public LoggerProxy(Login login, BlockingQueue<String> queue) {
        this.login = login;
        this.queue = queue;
        this.log = DefaultLog.getInstance();
    }

    public boolean login(String username, String password) throws RemoteException {
        try {
            queue.put(username + " logged in.");
        } catch (InterruptedException e) {
            return false;
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
