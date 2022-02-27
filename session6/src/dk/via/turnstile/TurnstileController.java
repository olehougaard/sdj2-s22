package dk.via.turnstile;

import java.beans.PropertyChangeListener;

public interface TurnstileController {
    String PASS_PROPERTY = "pass";
    String COIN_PROPERTY = "coin";

    void lock();
    void unlock();
    void returnCoin();
    void alarm();

    void addPropertyChangeListener(String propertyName, PropertyChangeListener listener);
    void removePropertyChangeListener(String propertyName, PropertyChangeListener listener);
}
