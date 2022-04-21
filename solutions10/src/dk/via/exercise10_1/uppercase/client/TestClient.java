package dk.via.exercise10_1.uppercase.client;

public class TestClient {
    public static void main(String[] args) throws Exception {
        Client client = new Client("localhost", 1099);
        String upper = client.uppercase("hello");
        System.out.println(upper);
    }
}
