package dk.via.runnable;

public class Characters implements Runnable {
    private int iterations;

    public Characters() {
        this(40);
    }

    public Characters(int iterations) {
        this.iterations = iterations;
    }

    @Override
    public void run() {
        for(int i = 0; i < iterations; i++) {
            for (char c = 'A'; c <= 'Z'; c++) {
                System.out.println(c);
            }
        }
    }
}
