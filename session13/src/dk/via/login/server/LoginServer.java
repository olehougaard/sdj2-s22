package dk.via.login.server;

import dk.via.login.dao.SqlUserDao;
import dk.via.login.dao.UserDao;
import dk.via.login.shared.Login;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class LoginServer {
    public static void main(String[] args) throws Exception {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(100);

        LoggerRunner loggerRunner = new LoggerRunner(queue);
        Thread loggerThread = new Thread(loggerRunner);
        loggerThread.start();

        UserDao dao = SqlUserDao.getInstance();
        UserStorage storage = new DaoStorageAdapter(dao);

        LoginImplementation login = new LoginImplementation(storage);
        Login logged = new LoggerProxy(login, queue);

        Remote remote = UnicastRemoteObject.exportObject(logged, 0);
        Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
        registry.bind("login", remote);
        System.out.println("Server running");
    }
}
