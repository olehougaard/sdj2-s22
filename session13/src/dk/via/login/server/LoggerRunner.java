package dk.via.login.server;

import dk.via.log.DefaultLog;

import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;

public class LoggerRunner implements Runnable {
    private final BlockingQueue<String> queue;
    private final DefaultLog log;

    public LoggerRunner(BlockingQueue<String> queue) {
        this.queue = queue;
        this.log = DefaultLog.getInstance();
    }

    public void run() {
        while(true) {
            try {
                String message = queue.take();
                log.log(message);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
