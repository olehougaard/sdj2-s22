package dk.via.turnstile;

public class TurnstileTest {
    public static void main(String[] args) throws InterruptedException {
        TurnstileSimulator simulator = new TurnstileSimulator();
        Turnstile turnstile = new Turnstile(simulator);
        simulator.addPropertyChangeListener(TurnstileController.COIN_PROPERTY, e -> turnstile.coin());
        simulator.addPropertyChangeListener(TurnstileController.PASS_PROPERTY, e -> turnstile.pass());

        simulator.simulatePass();
        Thread.sleep(2000);
        System.out.println();
        simulator.simulateCoin();
        simulator.simulatePass();
        Thread.sleep(2000);
        System.out.println();
        simulator.simulateCoin();
        simulator.simulateCoin();
        Thread.sleep(2000);
        System.out.println();
        simulator.simulatePass();
        simulator.simulatePass();
    }
}
