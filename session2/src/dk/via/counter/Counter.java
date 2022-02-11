package dk.via.counter;

public class Counter {
    private int count;

    public Counter() {
        this.count = 0;
    }

    public void increment() {
        synchronized (this) {
            count++;
        }
    }

    public int getCount() {
        return count;
    }
}
