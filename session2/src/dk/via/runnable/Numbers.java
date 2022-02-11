package dk.via.runnable;

public class Numbers implements Runnable {
    private int iterations;

    public Numbers() {
        this(1000);
    }

    public Numbers(int iterations) {
        this.iterations = iterations;
    }

    @Override
    public void run() {
        for(int i = 0; i < iterations; i++) {
            System.out.println(i);
        }
    }
}
