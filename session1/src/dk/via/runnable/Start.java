package dk.via.runnable;

public class Start {
    public static void main(String[] args) throws InterruptedException {
        Runnable r = new Numbers();
        Runnable r2 = new Characters();
        Thread t = new Thread(r);
        Thread t2 = new Thread(r2);
        t.start();
        t2.start();
        t.join();
        t2.join();
        System.out.println("Finished");
    }
}
