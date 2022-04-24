package dk.via.login.server;

import dk.via.login.dao.SqlUserDao;
import dk.via.login.dao.UserDao;
import dk.via.login.shared.Login;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class LoginServer {
    public static void main(String[] args) throws Exception {
        UserDao dao = SqlUserDao.getInstance();
        UserStorage storage = new DaoStorageAdapter(dao);
        LoginImplementation login = new LoginImplementation(storage);
        Login logged = new LoggerProxy(login);
        Remote remote = UnicastRemoteObject.exportObject(logged, 0);
        Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
        registry.bind("login", remote);
        System.out.println("Server running");
    }
}
