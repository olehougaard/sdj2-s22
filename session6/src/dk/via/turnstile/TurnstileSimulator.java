package dk.via.turnstile;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TurnstileSimulator implements TurnstileController {
    private final PropertyChangeSupport support;

    public TurnstileSimulator() {
        this.support = new PropertyChangeSupport(this);
    }

    @Override
    public void lock() {
        System.out.println("Locked");
    }

    @Override
    public void unlock() {
        System.out.println("Unlocked");
    }

    @Override
    public void returnCoin() {
        System.out.println("Coin returned");
    }

    @Override
    public void alarm() {
        System.out.println("Alarm!");
    }

    public void simulateCoin() {
        support.firePropertyChange(COIN_PROPERTY, false, true);
    }

    public void simulatePass() {
        support.firePropertyChange(PASS_PROPERTY, false, true);
    }

    @Override
    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(propertyName, listener);
    }

    @Override
    public void removePropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(propertyName, listener);
    }
}
