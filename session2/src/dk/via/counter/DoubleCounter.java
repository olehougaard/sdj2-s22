package dk.via.counter;

public class DoubleCounter {
    private int count1;
    private int count2;

    private final Object monitor1;
    private final Object monitor2;

    public DoubleCounter() {
        this.count1 = 0;
        this.count2 = 0;
        this.monitor1 = new Object();
        this.monitor2 = new Object();
    }

    public void increment1() {
        synchronized (monitor1) {
            count1++;
        }
    }

    public void increment2() {
        synchronized (monitor2) {
            count2++;
        }
    }

    public int getCount1() {
        return count1;
    }

    public int getCount2() {
        return count2;
    }
}
