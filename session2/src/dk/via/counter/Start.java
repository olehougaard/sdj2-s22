package dk.via.counter;

public class Start {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Counter other = new Counter();
        CounterIncrementer first = new CounterIncrementer(counter);
        CounterIncrementer second = new CounterIncrementer(other);
        Thread firstThread = new Thread(first);
        Thread secondThread = new Thread(second);
        firstThread.start();
        secondThread.start();
    }
}
