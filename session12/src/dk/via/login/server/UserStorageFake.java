package dk.via.login.server;

import dk.via.login.shared.User;

import java.rmi.RemoteException;
import java.util.HashMap;

public class UserStorageFake implements UserStorage {
    private final HashMap<String, User> users;

    public UserStorageFake() {
        users = new HashMap<>();
    }


    @Override
    public User getUser(String username) throws RemoteException {
        return users.get(username);
    }

    @Override
    public void storeUser(User user) throws RemoteException {
        users.put(user.getUserName(), user);
    }
}
