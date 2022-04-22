package dk.via.login.server;

import dk.via.login.dao.SqlUserDao;
import dk.via.login.dao.UserDao;
import dk.via.login.shared.Login;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class LoginServer {
    public static void main(String[] args) throws Exception {
        UserDao dao = SqlUserDao.getInstance();
        UserStorage storage = new DaoStorageAdapter(dao);
        LoginImplementation login = new LoginImplementation(storage);
        Login logged = new LoggerProxy(login);
        WhitelistLoginProxy whitelisted = new WhitelistLoginProxy(logged);
        whitelisted.permit("172.26.224.1");
        //Remote remote = UnicastRemoteObject.exportObject(logged, 0);
        Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
        registry.bind("login", whitelisted);
        System.out.println("Server running");
    }
}
