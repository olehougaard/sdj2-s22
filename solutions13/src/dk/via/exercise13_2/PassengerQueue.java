package dk.via.exercise13_2;

public interface PassengerQueue {
    void putPassengerInQueue(Passenger p);
    Passenger getNextPassenger() throws InterruptedException;
}
