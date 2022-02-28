package dk.via.turnstile;

public class Turnstile {
    private TurnstileController controller;
    private TurnstileState state;

    public Turnstile(TurnstileController controller) {
        this.controller = controller;
        this.state = new Closed(this);
    }

    public void coin() {
        state.onCoin();
    }

    public void pass() {
        state.onPass();
    }

    void setState(TurnstileState state) {
        this.state = state;
    }

    void lock() {
        controller.lock();
    }

    void unlock() {
        controller.unlock();
    }

    void returnCoin() {
        controller.returnCoin();
    }

    void alarm() {
        controller.alarm();
    }
}
