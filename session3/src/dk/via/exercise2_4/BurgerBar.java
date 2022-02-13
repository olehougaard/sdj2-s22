package dk.via.exercise2_4;

public class BurgerBar {
    private int numberOfBurgers;
    private int maxNumberOfBurgers;

    public BurgerBar(int maxNumberOfBurgers) {
        this.numberOfBurgers = 0;
        this.maxNumberOfBurgers = maxNumberOfBurgers;
    }

    public synchronized void makeBurger(String employeeName) {
    }

    public synchronized void eatBurger(String customerName) {
    }

    public int getNumberOfBurgers() {
        return numberOfBurgers;
    }
}
