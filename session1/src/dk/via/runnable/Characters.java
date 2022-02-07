package dk.via.runnable;

public class Characters implements Runnable {
    @Override
    public void run() {
        for(int i = 0; i < 40; i++) {
            for (char c = 'A'; c <= 'Z'; c++) {
                System.out.println(c);
            }
        }
    }
}
