package dk.via.traffic_property.traffic;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import static dk.via.traffic_property.traffic.LightColor.GREEN;


public class TrafficLight implements Runnable {
    private PropertyChangeSupport support = new PropertyChangeSupport(this);
    private LightColor color = GREEN;

    public synchronized void addObserver(PropertyChangeListener observer) {
        support.addPropertyChangeListener("color", observer);
    }



    public synchronized void removeObserver(PropertyChangeListener observer) {
        support.removePropertyChangeListener("color", observer);
    }

    public void run() {
        try {
            while (true) {
                Thread.sleep(1000);
                LightColor old = color;
                color = color.next();
                synchronized (this) {
                    support.firePropertyChange("color", old, color);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
